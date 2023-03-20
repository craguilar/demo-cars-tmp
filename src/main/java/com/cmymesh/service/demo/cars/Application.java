package com.cmymesh.service.demo.cars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Main entry point for Spring Boot application.
 * <p>
 * Added EnableJpaRepositories,EntityScan with hope to reduce startup time for Lambda use , based on
 * testing this saves only a few ms.
 */
@SpringBootApplication
@EnableJpaRepositories
@EntityScan("com.cmymesh.service.demo.cars.model.entity")
public class Application extends SpringBootServletInitializer {
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}