package com.techelevator.dao;

import com.techelevator.model.Animal;

import java.util.List;

public interface AnimalDao {

    List<Animal> findAll();

    Animal getAnimalById(int animal_id);

    List<Animal> getAnimalByBreed(String breed);

    List<Animal> getAnimalByType(String type);

    List<Animal> getAnimalByAge(String age);

    List<Animal> getAnimalByGender(String gender);

    List<Animal> getAnimalByColor(String color);

    List<Animal> getAnimalsByUserAdded(int addedBy);

    boolean updateAnimal(Animal animal);

    int create(Animal animal);
}
