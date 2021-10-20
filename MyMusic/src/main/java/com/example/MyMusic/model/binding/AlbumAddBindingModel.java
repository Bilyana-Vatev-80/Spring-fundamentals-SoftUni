package com.example.MyMusic.model.binding;

import com.example.MyMusic.model.entity.enums.ArtistNameEnum;
import com.example.MyMusic.model.entity.enums.GenreEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumAddBindingModel {

    @NotNull
    @Size(min = 3, max = 20)
    private String name;
    @NotNull
    @Size(min = 5)
    private String imageUrl;
    @NotNull
    @Size(min = 5)
    private String description;
    @NotNull
    @Min(10)
    private Integer copies;
    @NotNull
    @Positive
    private BigDecimal price;
    private String producer;
    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;
    @NotNull
    private GenreEnum genre;
    private ArtistNameEnum artist;

    public AlbumAddBindingModel() {
    }

    public String getName() {
        return name;
    }

    public AlbumAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public AlbumAddBindingModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AlbumAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getCopies() {
        return copies;
    }

    public AlbumAddBindingModel setCopies(Integer copies) {
        this.copies = copies;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AlbumAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getProducer() {
        return producer;
    }

    public AlbumAddBindingModel setProducer(String producer) {
        this.producer = producer;
        return this;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public AlbumAddBindingModel setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public GenreEnum getGenre() {
        return genre;
    }

    public AlbumAddBindingModel setGenre(GenreEnum genre) {
        this.genre = genre;
        return this;
    }

    public ArtistNameEnum getArtist() {
        return artist;
    }

    public AlbumAddBindingModel setArtist(ArtistNameEnum artist) {
        this.artist = artist;
        return this;
    }
}
