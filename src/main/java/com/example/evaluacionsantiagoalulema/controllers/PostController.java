package com.example.evaluacionsantiagoalulema.controllers;

import com.example.evaluacionsantiagoalulema.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/titles")
    public ResponseEntity<?> titlesByUserId(@RequestParam(required = false) Integer  userId) {
        if (userId == null) {
            return ResponseEntity.badRequest().body("Falta el parámetro userId.");
        }
        return ResponseEntity.ok(postService.getTitlesByUserId(userId));
    }

    @GetMapping("/refresh")
    public ResponseEntity<String> refresh() {
        int count = postService.refreshPosts();
        return ResponseEntity.ok("Posts refreshed. Inserted: " + count);
    }
}