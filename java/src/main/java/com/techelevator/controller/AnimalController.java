package com.techelevator.controller;

import com.techelevator.dao.AnimalDao;
import com.techelevator.model.Animal;
import org.springframework.http.HttpStatus;
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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/animals")
    public int createAnimal(@RequestBody Animal animal) {
        return animalDao.create(animal);
    }

    @GetMapping(path = "/animal/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Animal updateAnimal(@RequestBody AnimalDto animalDto, @PathVariable("id") Integer animalId) {
        Animal animal = animalDao.getAnimalById(animalId);

        animal.setName(animalDto.getName());
        animal.setType(animalDto.getType());
        animal.setDescription(animalDto.getDescription());
        animal.setAge(animalDto.getAge());
        animal.setGender(animalDto.getGender());
        animal.setAdopted(animalDto.isAdopted());
        animal.setBreed(animalDto.getBreed());
        animal.setColor(animalDto.getColor());
        animal.setTags(animalDto.getTags());

        animalDao.updateAnimal(animal);
        return animal;
    }
}
