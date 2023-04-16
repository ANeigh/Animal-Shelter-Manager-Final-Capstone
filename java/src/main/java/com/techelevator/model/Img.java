package com.techelevator.model;

import java.math.BigInteger;

public class Img {

    private int pet_id;
    private String url;
    private int animal_id;

    public Img() {}

    public Img(int pet_id, String url, int animal_id) {
        this.pet_id = pet_id;
        this.url = url;
        this.animal_id = animal_id;
    }

    public int getPet_id() {
        return pet_id;
    }

    public void setPet_id(int pet_id) {
        this.pet_id = pet_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getAnimal_id() {
        return animal_id;
    }

    public void setAnimal_id(int animal_id) {
        this.animal_id = animal_id;
    }
}
