package com.techelevator.dao;

import com.techelevator.model.Animal;
import com.techelevator.model.Application;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcApplicationDao implements ApplicationDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcApplicationDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Application> findAll() {
        List<Application> applications = new ArrayList<>();
        String sql = "SELECT * FROM applications";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Application app = mapRowToApplication(results);
            applications.add(app);
        }
        return applications;
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

    private Application mapRowToApplication(SqlRowSet rs) {
        Application app = new Application();
        app.setAppId(rs.getInt("app_id"));
        app.setFirstName(rs.getString("first_name"));
        app.setLastName(rs.getString("last_name"));
        app.setEmail(rs.getString("email"));
        app.setStatus(rs.getString("status"));
        app.setUsername(rs.getString("username"));
        app.setPhoneNumber(rs.getString("phone_number"));
        return app;
    }
}
