package com.prueba.demo.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "photos")
public class Photo {

    @Id
    private Integer id;
    private Integer albumId;
    private String title;
    private String url;
    private String thumbnailUrl;
    
   
    public Photo() {
       
    }
    
    
    public Photo(Integer id, Integer albumId, String title, String url, String thumbnailUrl) {
        super();
        this.id = id;
        this.albumId = albumId;
        this.title = title;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }


    public Photo(Photo photo) {
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

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Photo)) {
            return false;
        }
        Photo other = (Photo) obj;
        return Objects.equals(id, other.id);
    }
    
    
}
