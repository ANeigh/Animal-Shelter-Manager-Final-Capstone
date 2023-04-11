package com.techelevator.model;

import java.math.BigInteger;

public class Img {

    private int pet_id;
    private String url;

    public Img() {}

    public Img(int pet_id, String url) {
        this.pet_id = pet_id;
        this.url = url;
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
}
