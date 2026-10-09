package com.starnoh.chatapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record SendMessageRequest(
        @NotNull(message = "Sender ID is required")
        UUID senderId,
        @NotNull(message = "Recipient ID is required")
        UUID recipientId,
        @NotBlank(message = "Message is required")
        @Size(max = 255, message = "Message must not exceed 255 characters")
        String message
) {
}
