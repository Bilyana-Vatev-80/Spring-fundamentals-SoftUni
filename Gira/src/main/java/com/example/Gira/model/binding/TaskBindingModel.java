package com.example.Gira.model.binding;

import com.example.Gira.model.entity.Classification;
import com.example.Gira.model.entity.enums.ClassificationNameEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class TaskBindingModel {

    @Size(min = 3, max = 20, message = "Name length must be between 3 and 20 characters ")
    private String name;
    @Size(min = 5, message = "Description min length must be minimum 5")
    private String description;
    @FutureOrPresent(message = "Date cannot be in the past")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;
    @NotNull(message = "Classification cannot be null")
    private ClassificationNameEnum classification;

    public TaskBindingModel() {
    }

    public String getName() {
        return name;
    }

    public TaskBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TaskBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskBindingModel setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public ClassificationNameEnum getClassification() {
        return classification;
    }

    public TaskBindingModel setClassification(ClassificationNameEnum classification) {
        this.classification = classification;
        return this;
    }
}
