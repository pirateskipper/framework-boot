package com.example.demo;

import ch.qos.logback.classic.LoggerContext;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {
        log.info("application is started... && QueueLogback configuration....");
        LoggerContext context = (LoggerContext)LoggerFactory.getILoggerFactory();
        System.out.println(context.toString());
        SpringApplication.run(DemoApplication.class, args);
    }

}
