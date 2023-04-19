package com.techelevator.dao;

import com.techelevator.model.Application;

import java.util.List;

public interface ApplicationDao {

    List<Application> findAll();

    Application findApplicationById (int app_id);

    Application findApplicationByUsername (String username);

    Application findApplicationByEmail (String email);

    Application findApplicationByFullName(String first_name, String last_name);

    List<Application> findApplicationsByStatus (String status);
}
