package com.example.evaluacionsantiagoalulema.services;


import com.example.evaluacionsantiagoalulema.clients.ExternalPostClient;
import com.example.evaluacionsantiagoalulema.dtos.external.implementation_1.ExternalPostDto;
import com.example.evaluacionsantiagoalulema.repositories.PostRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

class PostServiceTest {

    @Test
    void refreshPosts_shouldDeleteAllAndSaveAllPosts() {
        ExternalPostClient client = mock(ExternalPostClient.class);
        PostRepository repository = mock(PostRepository.class);

        ExternalPostDto dto1 = new ExternalPostDto();
        dto1.id = 1;
        dto1.userId = 1;
        dto1.title = "Title 1";
        dto1.body = "Body 1";

        ExternalPostDto dto2 = new ExternalPostDto();
        dto2.id = 2;
        dto2.userId = 1;
        dto2.title = "Title 2";
        dto2.body = "Body 2";

        when(client.fetchPosts()).thenReturn(List.of(dto1, dto2));

        PostService service = new PostService(client, repository);

        int inserted = service.refreshPosts();

        assertEquals(2, inserted);
        verify(repository, times(1)).deleteAllInBatch();
        verify(repository, times(1)).saveAll(anyList());
    }

    @Test
    void getTitlesByUserId_shouldReturnTitles() {
        ExternalPostClient client = mock(ExternalPostClient.class);
        PostRepository repository = mock(PostRepository.class);

        when(repository.findTitlesByUserId(1))
                .thenReturn(List.of("Title A", "Title B"));

        PostService service = new PostService(client, repository);

        List<String> titles = service.getTitlesByUserId(1);

        assertEquals(2, titles.size());
        assertEquals("Title A", titles.get(0));
        assertEquals("Title B", titles.get(1));
    }
}