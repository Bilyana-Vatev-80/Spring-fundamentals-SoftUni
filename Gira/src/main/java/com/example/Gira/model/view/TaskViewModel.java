package com.example.Gira.model.view;

import com.example.Gira.model.entity.Classification;
import com.example.Gira.model.entity.User;
import com.example.Gira.model.entity.enums.ProgressEnum;

import java.time.LocalDate;

public class TaskViewModel {

    private Long id;
    private String name;
    private User assignedTo;
    private Classification classification;
    private LocalDate dueDate;
    private ProgressEnum progress;

    public TaskViewModel() {
    }

    public Long getId() {
        return id;
    }

    public TaskViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TaskViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public TaskViewModel setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
        return this;
    }

    public Classification getClassification() {
        return classification;
    }

    public TaskViewModel setClassification(Classification classification) {
        this.classification = classification;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskViewModel setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public ProgressEnum getProgress() {
        return progress;
    }

    public TaskViewModel setProgress(ProgressEnum progress) {
        this.progress = progress;
        return this;
    }
}
