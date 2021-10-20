package com.example.MyMusic.service.impl;

import com.example.MyMusic.model.entity.Album;
import com.example.MyMusic.model.service.AlbumServiceModel;
import com.example.MyMusic.model.view.AlbumViewModel;
import com.example.MyMusic.repository.AlbumRepository;
import com.example.MyMusic.security.CurrentUser;
import com.example.MyMusic.service.AlbumService;
import com.example.MyMusic.service.ArtistService;
import com.example.MyMusic.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;
    private final ModelMapper modelMapper;
    private final ArtistService artistService;
    private final CurrentUser currentUser;
    private final UserService userService;

    public AlbumServiceImpl(AlbumRepository albumRepository, ModelMapper modelMapper, ArtistService artistService, CurrentUser currentUser, UserService userService) {
        this.albumRepository = albumRepository;
        this.modelMapper = modelMapper;
        this.artistService = artistService;
        this.currentUser = currentUser;
        this.userService = userService;
    }

    @Override
    public void addAlbum(AlbumServiceModel albumServiceModel) {
        Album album = modelMapper.map(albumServiceModel, Album.class);
        album.setArtist(artistService.findArtistByName(albumServiceModel.getArtist()));
        album.setReleasedDate(albumServiceModel.getReleaseDate());
        album.setAddedFrom(userService.findById(currentUser.getId()));

        albumRepository.save(album);
    }

    @Override
    public void removeAlbum(Long id) {
        albumRepository.deleteById(id);
    }

    @Override
    public List<AlbumViewModel> findAllAlbums() {
        return albumRepository.findAll()
                .stream()
                .map(album -> {
                    AlbumViewModel albumViewModel = modelMapper.map(album, AlbumViewModel.class);
                    albumViewModel.setArtist(album.getArtist().getName());
                    albumViewModel.setReleaseDate(album.getReleasedDate());

                    return albumViewModel;
                })
                .collect(Collectors.toList());
    }
}
