package com.prueba.demo.service;

import java.util.List;

import com.prueba.demo.model.AlbumEnriched;


public interface AlbumsService {
    List<AlbumEnriched> getAllAlbumsEnrichedH2();
    List<AlbumEnriched> getAllAlbumsFromH2();;
    List<AlbumEnriched> getAllAlbumsEnrichedNoH2();
}