package com.example.Gira.servise;

import com.example.Gira.model.entity.Classification;
import com.example.Gira.model.entity.enums.ClassificationNameEnum;

import java.util.Optional;

public interface ClassificationService {
    void initialisedClassification();

    Classification finBy(ClassificationNameEnum name);
}
