package com.example.evaluacionsantiagoalulema.services;


import com.example.evaluacionsantiagoalulema.Entity.Post;
import com.example.evaluacionsantiagoalulema.clients.ExternalPostClient;
import com.example.evaluacionsantiagoalulema.repositories.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {

    private final ExternalPostClient externalPostClient;
    private final PostRepository postRepository;

    public PostService(ExternalPostClient externalPostClient, PostRepository postRepository) {
        this.externalPostClient = externalPostClient;
        this.postRepository = postRepository;
    }

    @Transactional
    public int refreshPosts() {
        postRepository.deleteAllInBatch();
        var external = externalPostClient.fetchPosts();

        var entities = external.stream()
                .map(p -> new Post(p.id, p.userId, p.title, p.body))
                .toList();

        postRepository.saveAll(entities);
        return entities.size();
    }

    @Transactional(readOnly = true)
    public List<String> getTitlesByUserId(Integer userId) {
        return postRepository.findTitlesByUserId(userId);
    }
}