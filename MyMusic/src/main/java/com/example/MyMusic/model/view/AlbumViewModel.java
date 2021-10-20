package com.example.MyMusic.model.view;

import com.example.MyMusic.model.entity.enums.ArtistNameEnum;
import com.example.MyMusic.model.entity.enums.GenreEnum;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumViewModel {


    private Long id;
    private String name;
    private String imageUrl;
    private ArtistNameEnum artist;
    private GenreEnum genre;
    private BigDecimal price;
    private Integer copies;
    private LocalDate releaseDate;

    public AlbumViewModel() {
    }

    public Long getId() {
        return id;
    }

    public AlbumViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AlbumViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public AlbumViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public ArtistNameEnum getArtist() {
        return artist;
    }

    public AlbumViewModel setArtist(ArtistNameEnum artist) {
        this.artist = artist;
        return this;
    }

    public GenreEnum getGenre() {
        return genre;
    }

    public AlbumViewModel setGenre(GenreEnum genre) {
        this.genre = genre;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AlbumViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Integer getCopies() {
        return copies;
    }

    public AlbumViewModel setCopies(Integer copies) {
        this.copies = copies;
        return this;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public AlbumViewModel setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }
}
