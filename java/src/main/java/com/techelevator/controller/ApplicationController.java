package com.techelevator.controller;

import com.techelevator.dao.ApplicationDao;
import com.techelevator.model.Animal;
import com.techelevator.model.Application;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ApplicationController {

    private final ApplicationDao appDao;

    public ApplicationController(ApplicationDao appDao) {
        this.appDao = appDao;
    }

    @GetMapping(path = "/appapproval")
    public List<Application> getAllApplications() {
        return appDao.getAllApplications();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/")
    public int createAnimal(@RequestBody Application app) {
        return appDao.create(app);
    }

}
