package com.prueba.demo.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "albums")
public class Album {
    
    @Id
    private Integer id;
    private Integer userId;
    private String title;
    
   
    public Album() {
        
    }

    
    public Album(Integer id, Integer userId, String title) {
        this.id = id;
        this.userId = userId;
        this.title = title;
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

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Album)) {
            return false;
        }
        Album other = (Album) obj;
        return Objects.equals(id, other.id);
    }
    
  
    
}
