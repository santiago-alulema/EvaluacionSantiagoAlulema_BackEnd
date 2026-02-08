package com.example.evaluacionsantiagoalulema.services;

import com.example.evaluacionsantiagoalulema.clients.ExternalUserClient;
import com.example.evaluacionsantiagoalulema.dtos.external.implementation_2.ExternalUserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final ExternalUserClient externalUserClient;

    public UserService(ExternalUserClient externalUserClient) {
        this.externalUserClient = externalUserClient;
    }

    public List<ExternalUserDto> getExternalUsers() {
        return externalUserClient.fetchUsers();
    }
}
