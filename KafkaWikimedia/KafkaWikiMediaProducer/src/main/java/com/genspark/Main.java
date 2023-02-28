package com.genspark;

import com.genspark.config.WikimediaChangesProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {
    @Autowired
    WikimediaChangesProducer wikimediaChangesProducer;
    public static void main(String[] args) {
        SpringApplication.run(Main.class);
       // System.out.println("Hello world!");
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Application is started");
        wikimediaChangesProducer.sendMessage();
    }
}