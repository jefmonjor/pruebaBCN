package com.prueba.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.demo.model.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Integer>{  
    
}
