package com.starnoh.chatapp.services;

import com.starnoh.chatapp.dto.SendMessageRequest;
import com.starnoh.chatapp.dto.SendMessageResponse;
import com.starnoh.chatapp.entities.Message;
import com.starnoh.chatapp.entities.User;
import com.starnoh.chatapp.exception.UserNotFoundException;
import com.starnoh.chatapp.repositories.MessageRepository;
import com.starnoh.chatapp.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class MessagesService {

    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    public SendMessageResponse sendMessage(SendMessageRequest request) {
        User sender = userRepository.findById(request.senderId())
                .orElseThrow(() -> new UserNotFoundException(request.senderId()));
        User recipient = userRepository.findById(request.recipientId())
                .orElseThrow(() -> new UserNotFoundException(request.recipientId()));

        Message message = new Message();
        message.setMessage(request.message().trim());
        message.setSender(sender);
        message.setRecipient(recipient);
        message.setCreatedAt(new Date());

        Message savedMessage = messageRepository.save(message);
        return new SendMessageResponse(
                savedMessage.getId(),
                sender.getId(),
                recipient.getId(),
                savedMessage.getMessage(),
                savedMessage.getCreatedAt()
        );
    }
}
