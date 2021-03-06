package bg.softuni.pathfinder.modul.entity;

import bg.softuni.pathfinder.modul.entity.enums.LevelEnum;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "routes")
public class Route extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;
    @Column(name = "gpx_coordinates", columnDefinition = "LONGTEXT")
    private String gpxCoordinates;
    @Column(name = "level")
    @Enumerated(EnumType.STRING)
    private LevelEnum level;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(name = "video_url")
    private String videoUrl;
    @OneToMany(mappedBy = "route",fetch = FetchType.EAGER)
    private Set<Picture> pictures;
    @ManyToOne
    private User author;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Category> categories;

    public String getName() {
        return name;
    }

    public Route setName(String name) {
        this.name = name;
        return this;
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public Route setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public Route setLevel(LevelEnum level) {
        this.level = level;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Route setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public Route setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public Route setAuthor(User author) {
        this.author = author;
        return this;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }

    public Route setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
        return this;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public Route setCategories(Set<Category> categories) {
        this.categories = categories;
        return this;
    }
}
