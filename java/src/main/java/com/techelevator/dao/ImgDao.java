package com.techelevator.dao;
import com.techelevator.model.Img;

import java.io.File;
import java.util.List;

public interface ImgDao {

    List<Img> findImgsByPet(int pet_id);

    Img findImgById(int img_id);

    int create (String url, int animalId);

    List<Img> getAllImages();
}
