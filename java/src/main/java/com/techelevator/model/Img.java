package com.techelevator.model;

import java.math.BigInteger;

public class Img {

    private int imgId;
    private String url;
    private int animalId;

    public Img() {}

    public Img(int imgId, String url, int animalId) {
        this.imgId = imgId;
        this.url = url;
        this.animalId = animalId;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }
}
