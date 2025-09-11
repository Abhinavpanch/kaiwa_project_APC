package com.kaiwa.controller;

import com.kaiwa.model.ChatMessage;
import com.kaiwa.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.Instant;
import java.util.List;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private ChatMessageRepository messageRepository;

    @GetMapping("/chat")
    public String chatPage(){
        return "chat";
    }



    @MessageMapping("/chat/{roomId}")
    public void send(@DestinationVariable String roomId, ChatMessage payload) {
        try {
            payload.setTimestamp(Instant.now());
            payload.setRoomId(roomId);

            // Save to database first
            ChatMessage savedMessage = messageRepository.save(payload);
            System.out.println("💾 Message saved: " + savedMessage.getContent());

            // Then broadcast to all subscribers
            messagingTemplate.convertAndSend("/topic/" + roomId, savedMessage);
            System.out.println("📡 Message broadcasted to /topic/" + roomId);

        } catch (Exception e) {
            System.err.println("❌ Error sending message: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
