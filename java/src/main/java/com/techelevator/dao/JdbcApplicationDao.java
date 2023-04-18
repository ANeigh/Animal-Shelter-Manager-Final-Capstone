package com.techelevator.dao;

import com.techelevator.model.Application;

import java.util.List;

public class JdbcApplicationDao implements ApplicationDao{
    @Override
    public Application findApplicationById(int appId) {
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
    public Application findApplicationByFullName(String firstName, String lastName) {
        return null;
    }

    @Override
    public List<Application> findApplicationsByStatus(String status) {
        return null;
    }
}
