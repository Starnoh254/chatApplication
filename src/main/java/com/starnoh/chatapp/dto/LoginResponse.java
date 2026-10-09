package com.starnoh.chatapp.dto;

public record LoginResponse(
        String message,
        String firstName,
        String lastName,
        String email
) {
}
