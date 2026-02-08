package com.example.evaluacionsantiagoalulema.controllers;


import com.example.evaluacionsantiagoalulema.dtos.external.implementation_2.ExternalUserDto;
import com.example.evaluacionsantiagoalulema.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/external")
public class ExternalUserController {

    private final UserService externalUserService;

    public ExternalUserController(UserService externalUserService) {
        this.externalUserService = externalUserService;
    }

    @GetMapping("/users")
    public List<ExternalUserDto> getUsers() {
        return externalUserService.getExternalUsers();
    }
}