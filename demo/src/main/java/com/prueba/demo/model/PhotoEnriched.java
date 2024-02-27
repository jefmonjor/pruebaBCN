package com.prueba.demo.model;

public class PhotoEnriched {
    private Integer id;
    private Integer albumId;
    private String title;
    private String url;
    private String thumbnailUrl;
    

    public PhotoEnriched() {
    }

    public PhotoEnriched(Photo photo) {
        this.id = photo.getId();
        this.albumId = photo.getAlbumId();
        this.title = photo.getTitle();
        this.url = photo.getUrl();
        this.thumbnailUrl = photo.getThumbnailUrl();
    }

    
    public Integer getId() {
        return id;
    }

    
    public void setId(Integer id) {
        this.id = id;
    }

    
    public Integer getAlbumId() {
        return albumId;
    }

    
    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    
    public String getTitle() {
        return title;
    }

    
    public void setTitle(String title) {
        this.title = title;
    }

    
    public String getUrl() {
        return url;
    }

    
    public void setUrl(String url) {
        this.url = url;
    }

    
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    
    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

   
}
