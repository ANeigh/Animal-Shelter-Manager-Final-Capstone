package com.techelevator.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.dao.AnimalDao;
import com.techelevator.dao.JdbcAnimalDao;
import com.techelevator.model.Img;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.techelevator.model.AnimalDto;
import com.techelevator.model.ImgDto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class PetfinderService {


    // this class will consume the Petfinder API to populate our SQL database
    private static final String apiUrl = "https://api.petfinder.com/v2/animals?location=15221&distance=13";
    private static URL API_BASE_URL;

    static {
        try {
            API_BASE_URL = new URL(apiUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private static final String API_TOKEN_URL = "https://api.petfinder.com/v2/oauth2/token";
    private static final String API_KEY = "p5gm05cGz2JFgEqr0wJtiTocY2grB6yFHkeBgGs9mCU5xWvCfE";
    private static final String API_SECRET = "ICaHA2TyKUQvZU6llSdlbGjH28GSFj6v4AfGO2BB";
    private final RestTemplate restTemplate = new RestTemplate();

    public String getToken() {
        //Acquire token from api using OAuthv2 protocol
        String urlencoded = "grant_type=client_credentials&client_id=" + API_KEY + "&client_secret=" + API_SECRET;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<String> entity = new HttpEntity<>(urlencoded, headers);
        ResponseEntity<Map> response = restTemplate.exchange(API_TOKEN_URL, HttpMethod.POST, entity, Map.class);
        return (String) response.getBody().get("access_token");
    }

    public void populateDB() throws IOException, SQLException {
        //Querying the API for animals
        int iterator = 0;
        int animalId = 0;
        List<List<ImgDto>> listOfImgLists = new ArrayList<>();
        List<AnimalDto> animalList = new ArrayList<>();
        int page = 1;
        boolean hasNextPage = true;
        //while-loop to access data from every page of the JSON results using above int and boolean
        while (hasNextPage) {
            //dynamic url
            URL apiPageUrl = new URL(apiUrl + "&page=" + page);
            HttpsURLConnection connection = (HttpsURLConnection) apiPageUrl.openConnection();
            //utilizing the above getToken() method to access the API
            connection.setRequestProperty("Authorization", "Bearer " + getToken());
            connection.setRequestMethod("GET");
            int statusCode = connection.getResponseCode();
            InputStream inputStream = statusCode < 400 ? connection.getInputStream() : connection.getErrorStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            String inputLine;
            //building the json results into a string
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //Reading the JSON from the API and converting it into Java AnimalDto Objects
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(response.toString());
            JsonNode animalsNode = rootNode.path("animals");

            for (JsonNode animalNode : animalsNode) {
                List<ImgDto> imgList = new ArrayList<>();

                AnimalDto animalDto = objectMapper.treeToValue(animalNode, AnimalDto.class);
                JsonNode breedsNode = animalNode.path("breeds");
                animalDto.setBreed(breedsNode.path("primary").asText());
                JsonNode colorsNode = animalNode.path("colors");
                animalDto.setColor(colorsNode.path("primary").asText());

                animalList.add(animalDto);


                JsonNode imgNodes = animalNode.path("photos");
                for (JsonNode imgNode : imgNodes) {

                    ImgDto imgDto = new ImgDto();
                    imgDto.setUrl(imgNode.path("full").asText());
                    imgList.add(imgDto);
                }
                listOfImgLists.add(imgList);


            }

            JsonNode paginationNode = rootNode.path("pagination");
            if (paginationNode.path("total_pages").asInt() == page) {
                hasNextPage = false;
            } else {
                page++;
            }
        }

        //using jsoup to scrape website for full description
        for (AnimalDto animal : animalList) {
            String webURL = animal.getUrl();
            String description = "";
            try {
                Document document = Jsoup.connect(webURL).get();
                Elements allElements = document.getAllElements();
                for (Element element : allElements) {
                    String[] wantedDiv = element.classNames().toArray(new String[]{});
                    if (wantedDiv.length == 1 && wantedDiv[0].equals("u-vr4x")) {
                        if (element.text().contains(animal.getName())) {
                            description = element.text();
                        }
                    }
                }
            } catch (IOException e) {
                throw new IOException();
            }
            animal.setDescription(description);
        }

        //Connecting to the database and inserting the list of animals to the animals table
        Connection sqlConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/final_capstone",
                "postgres", "postgres1");

        PreparedStatement statement = sqlConnection.prepareStatement("INSERT INTO animals (added_by, name, type, description, age, gender, adopted, breed, color, tags) VALUES (1, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        PreparedStatement statement2 = sqlConnection.prepareStatement("INSERT INTO imgs (animal_id, url) VALUES (?, ?)");
        PreparedStatement statement3 = sqlConnection.prepareStatement("SELECT animal_id FROM animals ORDER BY animal_id DESC LIMIT 1");
        for (AnimalDto animal : animalList) {
            statement.setString(1, animal.getName());
            statement.setString(2, animal.getType());
            statement.setString(3, animal.getDescription());
            statement.setString(4, animal.getAge());
            statement.setString(5, animal.getGender());
            statement.setBoolean(6, animal.isAdopted());
            statement.setString(7, animal.getBreed());
            statement.setString(8, animal.getColor());
            statement.setString(9, animal.getTags());
            statement.executeUpdate();

                ResultSet resultSet = statement3.executeQuery();
                if (resultSet.next()) {
                    animalId = resultSet.getInt("animal_id");
                }

            for (int i = iterator; i < animalList.size(); i++) {

                for (ImgDto imgUrl : listOfImgLists.get(i)) {
                    statement2.setInt(1, animalId);
                    statement2.setString(2, imgUrl.getUrl());
                    statement2.executeUpdate();
                }
                iterator++;
                break;
            }
        }
    }
}
