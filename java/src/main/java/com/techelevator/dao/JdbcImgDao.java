package com.techelevator.dao;

import com.techelevator.model.Img;

import java.util.List;

public class JdbcImgDao implements ImgDao {


    @Override
    public List<Img> findImgsByPet(int pet_id) {
        return null;
    }

    @Override
    public Img findImgById(int img_id) {
        return null;
    }

    @Override
    public boolean create(String url) {
        return false;
    }
}
