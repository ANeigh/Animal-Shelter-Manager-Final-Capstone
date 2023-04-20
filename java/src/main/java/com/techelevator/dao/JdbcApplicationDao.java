package com.techelevator.dao;

import com.techelevator.model.Application;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcApplicationDao implements ApplicationDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcApplicationDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

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

    @Override
    public List<Application> getAllApplications() {
        List<Application> apps = new ArrayList<>();
        String sql = "SELECT * FROM applications";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Application app = mapRowToApplications(results);
            apps.add(app);
        }
        return apps;
    }
    
    private Application mapRowToApplications(SqlRowSet rs) {
        Application app = new Application();
        app.setApp_id(rs.getInt("app_id"));
        app.setUsername(rs.getString("username"));
        app.setFirstName(rs.getString("first_name"));
        app.setLastName(rs.getString("last_name"));
        app.setEmail(rs.getString("email"));
        app.setStatus(rs.getString("status"));
        return app;
    }
}
