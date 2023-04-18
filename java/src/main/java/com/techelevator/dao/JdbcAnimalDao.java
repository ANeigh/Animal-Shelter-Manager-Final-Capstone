package com.techelevator.dao;

import com.techelevator.model.Animal;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcAnimalDao implements AnimalDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcAnimalDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Animal> findAll() {
        List<Animal> animals = new ArrayList<>();
        String sql = "SELECT * FROM animals";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Animal animal = mapRowToAnimal(results);
            animals.add(animal);
        }
        return animals;
    }

    @Override
    public Animal getAnimalById(int animal_id) {
        String sql = "SELECT * FROM animals WHERE animal_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, animal_id);
        if (results.next()) {
            return mapRowToAnimal(results);
        } else {
            return null;
        }
    }

    @Override
    public List<Animal> getAnimalByBreed(String breed) {
        List<Animal> animals = new ArrayList<>();
        String sql = "SELECT * FROM animals WHERE breed = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, breed);
        while (results.next()) {
            Animal animal = mapRowToAnimal(results);
            animals.add(animal);
        }
        return animals;
    }

    @Override
    public List<Animal> getAnimalByType(String type) {
        List<Animal> animals = new ArrayList<>();
        String sql = "SELECT * FROM animals WHERE type = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, type);
        while (results.next()) {
            Animal animal = mapRowToAnimal(results);
            animals.add(animal);
        }
        return animals;
    }

    @Override
    public List<Animal> getAnimalByAge(String age) {
        List<Animal> animals = new ArrayList<>();
        String sql = "SELECT * FROM animals WHERE age = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, age);
        while (results.next()) {
            Animal animal = mapRowToAnimal(results);
            animals.add(animal);
        }
        return animals;
    }

    @Override
    public List<Animal> getAnimalByGender(String gender) {
        List<Animal> animals = new ArrayList<>();
        String sql = "SELECT * FROM animals WHERE gender = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, gender);
        while (results.next()) {
            Animal animal = mapRowToAnimal(results);
            animals.add(animal);
        }
        return animals;
    }

    @Override
    public List<Animal> getAnimalByColor(String color) {
        List<Animal> animals = new ArrayList<>();
        String sql = "SELECT * FROM animals WHERE color = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, color);
        while (results.next()) {
            Animal animal = mapRowToAnimal(results);
            animals.add(animal);
        }
        return animals;
    }

    @Override
    public List<Animal> getAnimalsByUserAdded(int addedBy) {
        List<Animal> animals = new ArrayList<>();
        String sql = "SELECT * FROM animals WHERE added_by = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, addedBy);
        while (results.next()) {
            Animal animal = mapRowToAnimal(results);
            animals.add(animal);
        }
        return animals;
    }

    @Override
    public boolean updateAnimal(Animal animal) {
        boolean killMe = true;
        return killMe;
    }

    @Override
    public int create(Animal animal) {
        String sql = "INSERT INTO animals (animal_id, name, type, description, age, gender, adopted, breed, tags, color, added_by) VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING animal_id";
        int animalId;
        try {

            animalId = jdbcTemplate.queryForObject(sql, Integer.class, animal.getName(),
                    animal.getType(), animal.getDescription(), animal.getAge(), animal.getGender(),
                    animal.isAdopted(), animal.getBreed(), animal.getTags(), animal.getColor(), animal.getAddedBy());
        } catch(DataAccessException | NullPointerException e) {
            throw new NullPointerException("Unable to create new Animal");
        }
        return animalId;
    }

    private Animal mapRowToAnimal(SqlRowSet rs) {
        Animal animal = new Animal();
        animal.setAnimalId(rs.getInt("animal_id"));
        animal.setName(rs.getString("name"));
        animal.setType(rs.getString("type"));
        animal.setDescription(rs.getString("description"));
        animal.setAge(rs.getString("age"));
        animal.setGender(rs.getString("gender"));
        animal.setAdopted(rs.getBoolean("adopted"));
        animal.setBreed(rs.getString("breed"));
        animal.setColor(rs.getString("color"));
        animal.setAddedBy(rs.getInt("added_by"));
        return animal;
    }
}
