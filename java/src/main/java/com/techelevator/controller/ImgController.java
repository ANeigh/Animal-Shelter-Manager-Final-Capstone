package com.techelevator.controller;

import com.techelevator.dao.ImgDao;
import com.techelevator.model.Img;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ImgController {

    private final ImgDao imgDao;

    public ImgController(ImgDao imgDao) {
        this.imgDao = imgDao;
    }

    @GetMapping(path = "/imgs")
    public List<Img> getAllImages() {
        return imgDao.getAllImages();
    }

    @GetMapping(path = "/imgs/{id}")
    public List<Img> findImagsByPet(@PathVariable Integer id) {
        return imgDao.findImgsByPet(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/imgs")
    public int createImg(@RequestBody Img img) {
        return imgDao.create(img.getUrl(),img.getAnimalId());
    }
}
