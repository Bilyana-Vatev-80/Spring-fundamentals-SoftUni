package com.example.Gira.model.entity;

import com.example.Gira.model.entity.enums.ClassificationNameEnum;

import javax.persistence.*;

@Entity
@Table(name = "classifications")
public class Classification extends BaseEntity{

    @Enumerated(value = EnumType.STRING)
    private ClassificationNameEnum classificationName;
    @Column(columnDefinition = "TEXT")
    private String description;

    public Classification() {
    }

    public ClassificationNameEnum getClassificationName() {
        return classificationName;
    }

    public Classification setClassificationName(ClassificationNameEnum classificationName) {
        this.classificationName = classificationName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Classification setDescription(String description) {
        this.description = description;
        return this;
    }
}
