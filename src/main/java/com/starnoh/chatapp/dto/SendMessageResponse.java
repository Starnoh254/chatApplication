package com.starnoh.chatapp.dto;

import java.util.Date;
import java.util.UUID;

public record SendMessageResponse(
        UUID id,
        UUID senderId,
        UUID recipientId,
        String message,
        Date createdAt
) {
}
