package com.techelevator.dao;

import com.techelevator.model.Application;

import java.util.List;

public class JdbcApplicationDao implements ApplicationDao{
    @Override
    public Application findApplicationById(int app_id) {
        return null;
    }

    @Override
    public Application findApplicationByUsername(String username) {
        return null;
    }

    @Override
    public Application findApplicationByEmail(String email) {
        return null;
    }

    @Override
    public Application findApplicationByFullName(String first_name, String last_name) {
        return null;
    }

    @Override
    public List<Application> findApplicationsByStatus(String status) {
        return null;
    }
}
