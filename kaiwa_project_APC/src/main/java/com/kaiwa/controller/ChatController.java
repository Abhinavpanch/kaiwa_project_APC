package com.kaiwa.controller;

import com.kaiwa.model.ChatMessage;
import com.kaiwa.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.Instant;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private ChatMessageRepository messageRepository;

    @GetMapping("/chat")
    public String chatPage(){
        return "chat";             //templates/chat.html
    }

    @MessageMapping("/chat/{roomId}")
    public void send(@DestinationVariable String roomId, ChatMessage payload) {
        payload.setTimestamp(Instant.now());
        payload.setRoomId(roomId);
        messageRepository.save(payload);
        messagingTemplate.convertAndSend("/topic/" + roomId, payload);
    }
}
