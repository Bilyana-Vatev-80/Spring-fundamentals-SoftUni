package com.example.MyMusic.service;

import com.example.MyMusic.model.service.AlbumServiceModel;
import com.example.MyMusic.model.view.AlbumViewModel;

import java.util.List;

public interface AlbumService {
    void addAlbum(AlbumServiceModel albumServiceModel);

    void removeAlbum(Long id);

    List<AlbumViewModel> findAllAlbums();
}
