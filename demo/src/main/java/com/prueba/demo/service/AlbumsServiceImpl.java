package com.prueba.demo.service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.prueba.demo.model.Album;
import com.prueba.demo.model.AlbumEnriched;
import com.prueba.demo.model.Photo;
import com.prueba.demo.repository.AlbumRepository;
import com.prueba.demo.repository.PhotoRepository;



@Service
public class AlbumsServiceImpl implements AlbumsService {

    private final AlbumRepository albumRepository;
    private final PhotoRepository photoRepository;
    private final RestTemplate restTemplate;

    @Value("${api.albums.url}")
    private String albumsApiUrl;

    @Value("${api.photos.url}")
    private String photosApiUrl;

    public AlbumsServiceImpl(AlbumRepository albumRepository, PhotoRepository photoRepository, RestTemplate restTemplate) {
        this.albumRepository = albumRepository;
        this.photoRepository = photoRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<AlbumEnriched> getAllAlbumsEnrichedH2() {
        List<Album> albums = albumRepository.findAll();
        List<Photo> photos = photoRepository.findAll();
        return enrichAlbumsWithPhotos(albums, photos);
    }

    @Override
    public List<AlbumEnriched> getAllAlbumsFromH2() {
        List<Album> albums = albumRepository.findAll();
        return mapAlbumsToEnriched(albums);
    }

    @Override
    public List<AlbumEnriched> getAllAlbumsEnrichedNoH2() {
        List<Album> albums = fetchDataFromApi(albumsApiUrl, Album.class);
        List<Photo> photos = fetchDataFromApi(photosApiUrl, Photo.class);
        return enrichAlbumsWithPhotos(albums, photos);
    }

    private <T> List<T> fetchDataFromApi(String apiUrl, Class<T> responseType) {
        ResponseEntity<T[]> responseEntity = restTemplate.getForEntity(apiUrl, (Class<T[]>) Array.newInstance(responseType, 0).getClass());
        T[] resultArray = responseEntity.getBody();
        return resultArray != null ? Arrays.asList(resultArray) : new ArrayList<>();
    }

    private List<AlbumEnriched> enrichAlbumsWithPhotos(List<Album> albums, List<Photo> photos) {
        List<AlbumEnriched> enrichedAlbums = new ArrayList<>();
        albums.forEach(album -> {
            List<Photo> albumPhotos = photos.stream()
                    .filter(photo -> photo.getAlbumId().equals(album.getId()))
                    .collect(Collectors.toList());

            AlbumEnriched enrichedAlbum = new AlbumEnriched();
            enrichedAlbum.setId(album.getId());
            enrichedAlbum.setUserId(album.getUserId());
            enrichedAlbum.setTitle(album.getTitle());
            enrichedAlbum.setPhotos(albumPhotos);

            enrichedAlbums.add(enrichedAlbum);
        });

        return enrichedAlbums;
    }

    private List<AlbumEnriched> mapAlbumsToEnriched(List<Album> albums) {
        return albums.stream()
                .map(album -> {
                    AlbumEnriched enrichedAlbum = new AlbumEnriched();
                    enrichedAlbum.setId(album.getId());
                    enrichedAlbum.setUserId(album.getUserId());
                    enrichedAlbum.setTitle(album.getTitle());
                    enrichedAlbum.setPhotos(Collections.emptyList()); 
                    return enrichedAlbum;
                })
                .collect(Collectors.toList());
    }
}
