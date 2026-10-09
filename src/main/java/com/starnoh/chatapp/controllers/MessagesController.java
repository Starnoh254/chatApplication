package com.starnoh.chatapp.controllers;

import com.starnoh.chatapp.dto.SendMessageRequest;
import com.starnoh.chatapp.dto.SendMessageResponse;
import com.starnoh.chatapp.services.MessagesService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/messages")
@AllArgsConstructor
public class MessagesController {

    private final MessagesService messagesService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SendMessageResponse sendMessage(
            @Valid @RequestBody SendMessageRequest request
    ) {
        return messagesService.sendMessage(request);
    }
}
