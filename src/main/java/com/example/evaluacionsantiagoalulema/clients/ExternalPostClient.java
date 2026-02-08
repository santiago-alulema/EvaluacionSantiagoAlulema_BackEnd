package com.example.evaluacionsantiagoalulema.clients;

import com.example.evaluacionsantiagoalulema.dtos.external.implementation_1.ExternalPostDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class ExternalPostClient {

    private static final String URL = "https://jsonplaceholder.typicode.com/posts";
    private final RestTemplate restTemplate;

    public ExternalPostClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<ExternalPostDto> fetchPosts() {
        ExternalPostDto[] response = restTemplate.getForObject(URL, ExternalPostDto[].class);
        if (response == null) return List.of();
        return Arrays.asList(response);
    }
}
