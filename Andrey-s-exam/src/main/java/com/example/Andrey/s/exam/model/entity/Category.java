package com.example.Andrey.s.exam.model.entity;

import com.example.Andrey.s.exam.model.entity.enums.CategoryNameEnum;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    @Enumerated(value = EnumType.STRING)
    private CategoryNameEnum name;
    @Column(columnDefinition = "TEXT")
    private String description;

    public Category() {
    }

    public Category(CategoryNameEnum name, String description) {
        this.name = name;
        this.description = description;
    }

    public CategoryNameEnum getName() {
        return name;
    }

    public Category setName(CategoryNameEnum name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Category setDescription(String description) {
        this.description = description;
        return this;
    }
}
