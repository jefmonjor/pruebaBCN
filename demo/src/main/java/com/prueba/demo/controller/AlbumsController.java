package com.prueba.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.demo.model.AlbumEnriched;
import com.prueba.demo.service.AlbumsService;

@RestController
@RequestMapping("/api/v1")
public class AlbumsController {

    private final AlbumsService albumsService;

    @Autowired
    public AlbumsController(AlbumsService albumsService) {
        this.albumsService = albumsService;
    }

    @GetMapping("/albums-enriched-h2")
    public ResponseEntity<List<AlbumEnriched>> getAllAlbumsEnrichedH2() {
        List<AlbumEnriched> enrichedAlbums = albumsService.getAllAlbumsEnrichedH2();
        return ResponseEntity.ok(enrichedAlbums);
    }

    @GetMapping("/albums-from-h2")
    public ResponseEntity<List<AlbumEnriched>> getAllAlbumsFromH2() {
        List<AlbumEnriched> enrichedAlbums = albumsService.getAllAlbumsFromH2();
        return ResponseEntity.ok(enrichedAlbums);
    }

    @GetMapping("/albums-enriched-no-h2")
    public ResponseEntity<List<AlbumEnriched>> getAllAlbumsEnrichedNoH2() {
        List<AlbumEnriched> enrichedAlbums = albumsService.getAllAlbumsEnrichedNoH2();
        return ResponseEntity.ok(enrichedAlbums);
    }
}
