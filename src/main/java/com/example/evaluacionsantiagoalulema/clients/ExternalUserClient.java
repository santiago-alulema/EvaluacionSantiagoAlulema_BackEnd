package com.example.evaluacionsantiagoalulema.clients;

import com.example.evaluacionsantiagoalulema.dtos.external.implementation_2.ExternalUserDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class ExternalUserClient {
    private static final String URL = "https://jsonplaceholder.typicode.com/users";
    private final RestTemplate restTemplate;

    public ExternalUserClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<ExternalUserDto> fetchUsers() {
        ExternalUserDto[] response = restTemplate.getForObject(URL, ExternalUserDto[].class);
        if (response == null) return List.of();
        return Arrays.asList(response);
    }
}
