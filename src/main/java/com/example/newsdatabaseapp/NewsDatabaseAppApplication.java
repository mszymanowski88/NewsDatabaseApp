package com.example.newsdatabaseapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class NewsDatabaseAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewsDatabaseAppApplication.class, args);
    }

}
