package bg.softuni.pathfinder.modul.service;

import bg.softuni.pathfinder.modul.entity.Category;
import bg.softuni.pathfinder.modul.entity.Picture;
import bg.softuni.pathfinder.modul.entity.User;
import bg.softuni.pathfinder.modul.entity.enums.LevelEnum;

import javax.persistence.*;
import java.util.Set;

public class RoutServiceModel {

    private Long id;
    private String name;
    private String gpxCoordinates;
    private LevelEnum level;
    private String description;
    private String videoUrl;
    private Set<Picture> pictures;
    private User author;
    private Set<Category> categories;

    public RoutServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public RoutServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RoutServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public RoutServiceModel setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public RoutServiceModel setLevel(LevelEnum level) {
        this.level = level;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RoutServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public RoutServiceModel setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }

    public RoutServiceModel setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public RoutServiceModel setAuthor(User author) {
        this.author = author;
        return this;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public RoutServiceModel setCategories(Set<Category> categories) {
        this.categories = categories;
        return this;
    }
}
