package com.prueba.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.demo.model.Album;

public interface AlbumRepository extends JpaRepository<Album, Integer>{

}
