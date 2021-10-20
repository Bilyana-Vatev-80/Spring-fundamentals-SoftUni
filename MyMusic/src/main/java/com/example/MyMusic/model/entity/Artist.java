package com.example.MyMusic.model.entity;

import com.example.MyMusic.model.entity.enums.ArtistNameEnum;

import javax.persistence.*;

@Entity
@Table(name = "artists")
public class Artist extends BaseEntity{

    @Enumerated(value = EnumType.STRING)
    private ArtistNameEnum name;
    @Column(columnDefinition = "TEXT")
    private String careerInformation;

    public Artist() {
    }

    public ArtistNameEnum getName() {
        return name;
    }

    public Artist setName(ArtistNameEnum name) {
        this.name = name;
        return this;
    }

    public String getCareerInformation() {
        return careerInformation;
    }

    public Artist setCareerInformation(String careerInformation) {
        this.careerInformation = careerInformation;
        return this;
    }
}
