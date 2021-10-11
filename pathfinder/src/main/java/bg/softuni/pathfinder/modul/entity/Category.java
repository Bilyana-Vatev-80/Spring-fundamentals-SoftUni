package bg.softuni.pathfinder.modul.entity;

import bg.softuni.pathfinder.modul.entity.enums.CategoryEnum;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    @Column(columnDefinition = "TEXT")
    private String description;
    @Enumerated(EnumType.STRING)
    private CategoryEnum name;

    public Category() {
    }

    public String getDescription() {
        return description;
    }

    public Category setDescription(String description) {
        this.description = description;
        return this;
    }

    public CategoryEnum getName() {
        return name;
    }

    public Category setName(CategoryEnum name) {
        this.name = name;
        return this;
    }
}
