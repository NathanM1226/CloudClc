package com.gcu;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication(scanBasePackages = "com.gcu")
public class Cars2Application {

    public static void main(String[] args) {
        log.info("Starting Cars2Application...");
        SpringApplication.run(Cars2Application.class, args);
        log.info("Cars2Application started successfully.");
    }
}
