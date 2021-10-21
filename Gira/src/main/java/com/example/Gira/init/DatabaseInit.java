package com.example.Gira.init;

import com.example.Gira.servise.ClassificationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInit implements CommandLineRunner {

    private final ClassificationService classificationService;

    public DatabaseInit(ClassificationService classificationService) {
        this.classificationService = classificationService;
    }

    @Override
    public void run(String... args) throws Exception {
        classificationService.initialisedClassification();
    }
}
