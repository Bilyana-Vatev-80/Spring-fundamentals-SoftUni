package com.example.exam.model.binding;

import com.example.exam.model.entity.CategoryNameEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class ShipAddBindingModel {
    @Size(min = 2, max = 10)
    private String name;
    @Positive
    private Integer power;
    @Positive
    private Integer health;
    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdDate;
    private CategoryNameEnum category;

    public ShipAddBindingModel() {
    }

    public String getName() {
        return name;
    }

    public ShipAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getPower() {
        return power;
    }

    public ShipAddBindingModel setPower(Integer power) {
        this.power = power;
        return this;
    }

    public Integer getHealth() {
        return health;
    }

    public ShipAddBindingModel setHealth(Integer health) {
        this.health = health;
        return this;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public ShipAddBindingModel setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public ShipAddBindingModel setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }
}
