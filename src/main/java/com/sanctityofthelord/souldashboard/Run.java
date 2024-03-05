package com.sanctityofthelord.souldashboard;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Run {
    private static Logger logger = LoggerFactory.getLogger(Run.class);

    public static void main(String[] args) {
        try {
            logger.info("RESTFul Application Starting.");
            SpringApplication.run(Run.class, args);
            logger.info("RESTFul Application Started.");
        }
        catch(Exception e) {
            logger.error("RESTFul Application Failed to Start.",e);
        }
    }
}
