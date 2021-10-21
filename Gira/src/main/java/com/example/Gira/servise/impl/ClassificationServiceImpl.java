package com.example.Gira.servise.impl;

import com.example.Gira.model.entity.Classification;
import com.example.Gira.model.entity.enums.ClassificationNameEnum;
import com.example.Gira.repository.ClassificationRepository;
import com.example.Gira.servise.ClassificationService;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class ClassificationServiceImpl implements ClassificationService {

    private final ClassificationRepository classificationRepository;

    public ClassificationServiceImpl(ClassificationRepository classificationRepository) {
        this.classificationRepository = classificationRepository;
    }

    @Override
    public void initialisedClassification() {
        if(classificationRepository.count() == 0){
            Arrays.stream(ClassificationNameEnum.values())
                    .forEach(classificationNameEnum -> {
                        Classification classification = new Classification();
                        classification.setClassificationName(classificationNameEnum);
                        switch (classificationNameEnum){
                            case SUPPORT:
                                classification.setDescription("This support classification");
                                break;
                            case BUG:
                                classification.setDescription("This bug classification");
                                break;
                            case FEATURE:
                                classification.setDescription("This feature classification");
                                break;
                            case OTHER:
                                classification.setDescription("This other classification");
                        }

                        classificationRepository.save(classification);
                    });
        }
    }

    @Override
    public Classification finBy(ClassificationNameEnum name) {
        return classificationRepository.findByClassificationName(name)
                .orElse(null);
    }
}
