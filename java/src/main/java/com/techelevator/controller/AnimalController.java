package com.techelevator.controller;

import com.techelevator.dao.AnimalDao;
import com.techelevator.model.Animal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnimalController {

    private final AnimalDao animalDao;

    public AnimalController(AnimalDao animalDao) {
        this.animalDao = animalDao;
    }

    @GetMapping(path = "/animals")
    public List<Animal> getAllAnimals() {
        return animalDao.findAll();
    }

    @GetMapping(path = "/animals/{type}")
    public List<Animal> getAnimalsByType(@PathVariable String type) {
        return animalDao.getAnimalByType(type);
    }


}
