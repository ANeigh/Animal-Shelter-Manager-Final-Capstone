package com.techelevator.controller;

import com.techelevator.dao.AnimalDao;
import com.techelevator.model.Animal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
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

    @GetMapping(path = "/animal/{id}")
    public Animal getAnimalById(@PathVariable int animalId) {
        return animalDao.getAnimalById(animalId);
    }
}
