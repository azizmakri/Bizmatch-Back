package com.esprit.bizmatch_gestionevenement_conference;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class BizMatchGestionEvenementConferenceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BizMatchGestionEvenementConferenceApplication.class, args);
    }

}