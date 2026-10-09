package com.starnoh.chatapp.dto;

public record RegisterResponse(
        String message,
        String firstName,
        String lastName,
        String email
) {
}
