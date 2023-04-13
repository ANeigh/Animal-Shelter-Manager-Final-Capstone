package com.techelevator.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.techelevator.model.AnimalDto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import java.net.HttpURLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

@Component
public class PetfinderService {


    // this class will consume the Petfinder API to populate our SQL database

    private static final String apiUrl = "https://api.petfinder.com/v2/animals?location=15221&distance=10";
    private static URL API_BASE_URL;
    static {
        try {
            API_BASE_URL = new URL(apiUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    private static final String API_TOKEN_URL = "https://api.petfinder.com/v2/oauth2/token";
    private static final String API_KEY = "AfkgJyAkjU8PDzvpybNnXHqvYSpl5bZRqwnVkB90wq59dN49Ra";
    private static final String API_SECRET = "uDkeVqfVwb4cg3R9uEsezKhnu8AvQ5TfNbTLkfdS";
    private final RestTemplate restTemplate = new RestTemplate();

    public String getToken() {
        String urlencoded = "grant_type=client_credentials&client_id=" + API_KEY + "&client_secret=" + API_SECRET;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<String> entity = new HttpEntity<>(urlencoded, headers);
        ResponseEntity<Map> response = restTemplate.exchange(API_TOKEN_URL, HttpMethod.POST, entity, Map.class);
        return (String) response.getBody().get("access_token");
    }

    public void populateDB() throws IOException, SQLException {

        HttpsURLConnection connection = (HttpsURLConnection) API_BASE_URL.openConnection();
        connection.setRequestProperty("Authorization", "Bearer " + getToken());
        connection.setRequestMethod("GET");
        int statusCode = connection.getResponseCode();
        InputStream inputStream = statusCode < 400 ? connection.getInputStream() : connection.getErrorStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        ObjectMapper objectMapper = new ObjectMapper();

// assuming responseBody is the JSON data as a String
        JsonNode rootNode = objectMapper.readTree(response.toString());
        JsonNode animalsNode = rootNode.path("animals");

        List<AnimalDto> animalList = new ArrayList<>();
        for (JsonNode animalNode : animalsNode) {
            AnimalDto animalDto = objectMapper.treeToValue(animalNode, AnimalDto.class);
            animalList.add(animalDto);
        }

        for (AnimalDto animal : animalList) {
            animal.setDescription("d");
        }


        Connection sqlConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/final_capstone",
                "postgres", "postgres1");
      //  PreparedStatement statement = sqlConnection.prepareStatement("INSERT INTO animals (animal_id, added_by," +
        //        "name, type, description, age, gender, adopted, breed, color, tags) VALUES (DEFAULT, 1, ?, ?, ?, ?, ?," +
        //        "?, ?, ?, ?)");

        PreparedStatement statement = sqlConnection.prepareStatement("INSERT INTO animals (added_by, name, type, description, age, gender, adopted, breed, color, tags) VALUES (1, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

        for (AnimalDto animal : animalList) {
            statement.setString(1, animal.getName());
            statement.setString(2, animal.getType());
            statement.setString(3, animal.getDescription());
            statement.setString(4, animal.getAge());
            statement.setString(5, animal.getGender());
            statement.setBoolean(6,animal.isAdopted());
            statement.setString(7, animal.getBreed());
            statement.setString(8, animal.getColor());
            statement.setString(9, animal.getTags());
            statement.executeUpdate();
        }
    }

    public void testGetToken() {
        PetfinderService petfinderService = new PetfinderService();
        String token = petfinderService.getToken();
        assertNotNull(token);
    }
}
