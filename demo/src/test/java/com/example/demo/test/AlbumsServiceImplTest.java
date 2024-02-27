package com.example.demo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.web.client.RestTemplate;

import com.prueba.demo.model.Album;
import com.prueba.demo.model.AlbumEnriched;
import com.prueba.demo.model.Photo;
import com.prueba.demo.repository.AlbumRepository;
import com.prueba.demo.repository.PhotoRepository;
import com.prueba.demo.service.AlbumsServiceImpl;

public class AlbumsServiceImplTest {

    @Mock
    private AlbumRepository albumRepository;

    @Mock
    private PhotoRepository photoRepository;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private AlbumsServiceImpl albumsService;

    @Test
    void testGetAllAlbumsEnrichedH2() {
        List<Album> mockAlbums = Arrays.asList(
                new Album(1, 1, "quidem molestiae enim"),
                new Album(2, 1, "sunt qui excepturi placeat culpa"),
                new Album(3, 1, "omnis laborum odio")
        );

        List<Photo> mockPhotos = Arrays.asList(
                new Photo(1, 1, "accusamus beatae ad facilis cum similique qui sunt", "https://via.placeholder.com/600/92c952", "https://via.placeholder.com/150/92c952"),
                new Photo(2, 1, "reprehenderit est deserunt velit ipsam", "https://via.placeholder.com/600/771796", "https://via.placeholder.com/150/771796")
                );

        when(albumRepository.findAll()).thenReturn(mockAlbums);
        when(photoRepository.findAll()).thenReturn(mockPhotos);

        List<AlbumEnriched> result = albumsService.getAllAlbumsEnrichedH2();

        verify(albumRepository, times(1)).findAll();
        verify(photoRepository, times(1)).findAll();

        assertEquals(3, result.size()); 
        assertEquals("quidem molestiae enim", result.get(0).getTitle());
        assertEquals(2, result.get(0).getPhotos().size()); 
    }

}

