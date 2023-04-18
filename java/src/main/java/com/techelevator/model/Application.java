package com.techelevator.model;

public class Application {

    private int appId;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String status;

    public Application() {}

    public Application(int app_id, String username, String first_name, String last_name, String email, String status) {
        this.appId = app_id;
        this.username = username;
        this.firstName = first_name;
        this.lastName = last_name;
        this.email = email;
        this.status = status;
    }

    public int getApp_id() {
        return appId;
    }

    public void setApp_id(int app_id) {
        this.appId = app_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + appId +
                "username" + username +
                "first_name" + firstName +
                "last_name" + lastName +
                "email" + email +
                "status" + status +
                '}';

    }
}
