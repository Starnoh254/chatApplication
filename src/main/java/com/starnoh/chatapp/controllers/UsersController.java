package com.starnoh.chatapp.controllers;

import com.starnoh.chatapp.dto.RegisterRequest;
import com.starnoh.chatapp.dto.RegisterResponse;
import com.starnoh.chatapp.dto.LoginRequest;
import com.starnoh.chatapp.dto.LoginResponse;
import com.starnoh.chatapp.services.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RegisterResponse register(
            @Valid @RequestBody RegisterRequest request
    ) {
        return usersService.register(request);
    }

    @PostMapping("/login")
    public LoginResponse login(
            @Valid @RequestBody LoginRequest request
    ) {
        return usersService.login(request);
    }
}
