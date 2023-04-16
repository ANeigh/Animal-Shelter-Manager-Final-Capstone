package com.techelevator.dao;

import com.techelevator.model.Img;
import com.techelevator.model.ImgDto;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcImgDao implements ImgDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcImgDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Img> findImgsByPet(int pet_id) {
        List<Img> imgs = new ArrayList<>();
        String sql = "select * from imgs where animal_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, pet_id);
        while (results.next()) {
            Img img = mapRowToImg(results);
            imgs.add(img);
        }
        return imgs;
    }

    @Override
    public Img findImgById(int img_id) {
        return null;
    }

    @Override
    public int create(String url, int animalId) {
        String sql = "INSERT INTO imgs (animal_id, img_id, url) VALUES (?, DEFAULT, ?) RETURNING img_id";
        int imgId;
        try {
            imgId = jdbcTemplate.queryForObject(sql, Integer.class, animalId, url);
        } catch (DataAccessException | NullPointerException e) {
            throw new NullPointerException("Unable to save image");
        }
        return imgId;
    }

    public List<Img> getAllImages(){
        List<Img> imgs = new ArrayList<>();
        String sql = "select * from imgs";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Img img = mapRowToImg(results);
            imgs.add(img);
        }
        return imgs;
    }



    private Img mapRowToImg(SqlRowSet rs) {
        Img img = new Img();
        img.setPet_id (rs.getInt("img_id"));
        img.setAnimal_id(rs.getInt("animal_id"));
        img.setUrl(rs.getString("url"));
        return img;
    }
}
