package com.example.opportunitecollaboration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OpportuniteCollaborationApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpportuniteCollaborationApplication.class, args);
    }

}
