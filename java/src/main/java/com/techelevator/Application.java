package com.techelevator;
import com.techelevator.service.PetfinderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.sql.SQLException;


@SpringBootApplication
public class Application {

    public static void main(String[] args) throws SQLException, IOException {
        SpringApplication.run(Application.class, args);

        PetfinderService petfinderService = new PetfinderService();
//        petfinderService.populateDB();

    }

}
