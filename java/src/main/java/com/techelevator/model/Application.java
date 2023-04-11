package com.techelevator.model;

public class Application {

    private int app_id;
    private String username;
    private String first_name;
    private String last_name;
    private String email;
    private String status;

    public Application() {}

    public Application(int app_id, String username, String first_name, String last_name, String email, String status) {
        this.app_id = app_id;
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.status = status;
    }

    public int getApp_id() {
        return app_id;
    }

    public void setApp_id(int app_id) {
        this.app_id = app_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + app_id +
                "username" + username +
                "first_name" + first_name +
                "last_name" + last_name +
                "email" + email +
                "status" + status +
                '}';

    }
}
