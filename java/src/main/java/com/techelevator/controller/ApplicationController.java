package com.techelevator.controller;

import com.techelevator.dao.ApplicationDao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

    private final ApplicationDao applicationDao;

    public ApplicationController(ApplicationDao applicationDao) {
        this.applicationDao = applicationDao;
    }

    @GetMapping(path = "/appapproval")
    public 

}
