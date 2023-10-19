package com.esprit.prestationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PrestationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrestationServiceApplication.class, args);
    }

}
