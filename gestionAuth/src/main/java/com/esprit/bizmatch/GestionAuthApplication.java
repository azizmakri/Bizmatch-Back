package com.esprit.bizmatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
public class GestionAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionAuthApplication.class, args);
    }

}
