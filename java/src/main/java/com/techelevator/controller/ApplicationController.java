package com.techelevator.controller;

import com.techelevator.dao.ApplicationDao;
import com.techelevator.model.Application;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin
public class ApplicationController {

    private final ApplicationDao applicationDao;

    public ApplicationController(ApplicationDao applicationDao) {
        this.applicationDao = applicationDao;
    }

    @GetMapping(path = "/appapproval")




//    private final ApplicationDao appDao;
//
//    public ApplicationController(ApplicationDao appDao) {
//        this.appDao = appDao;
//    }
//
//    @GetMapping(path = "/appapproval")
//    public List<Application> getAllApplications() {
//        return appDao.getAllApplications();
//    }

}
