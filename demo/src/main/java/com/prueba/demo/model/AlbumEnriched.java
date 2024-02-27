package com.prueba.demo.model;

import java.util.List;

public class AlbumEnriched {

    private Integer id;
    private Integer userId;
    private String title;
    private List<Photo> photos;


    public AlbumEnriched() {
    }

    public AlbumEnriched(Integer id, Integer userId, String title, List<Photo> photos) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.photos = photos;
    }

    /**
     * @param album
     * @param albumPhotos
     */
    public AlbumEnriched(Album album, List<PhotoEnriched> albumPhotos) {
        // TODO Esbozo de constructor generado automáticamente
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
}

