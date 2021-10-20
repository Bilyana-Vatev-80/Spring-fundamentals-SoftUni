package com.example.MyMusic.service;

import com.example.MyMusic.model.entity.Artist;
import com.example.MyMusic.model.entity.enums.ArtistNameEnum;

public interface ArtistService {
    void initArtists();

    Artist findArtistByName(ArtistNameEnum artist);
}
