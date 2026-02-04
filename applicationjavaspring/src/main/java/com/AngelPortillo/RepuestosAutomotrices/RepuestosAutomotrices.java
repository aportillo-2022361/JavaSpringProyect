package com.AngelPortillo.RepuestosAutomotrices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RepuestosAutomotrices implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(RepuestosAutomotrices.class, args);
    }

    @Override
    public void run (String... args) throws Exception{
        System.out.println("Test API FUNCIONANDO");
    }

}
