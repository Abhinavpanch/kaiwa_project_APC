package com.kaiwa.controller;

import com.kaiwa.model.ChatMessage;
import com.kaiwa.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private ChatMessageRepository messageRepository;

    @GetMapping("/{roomId}")
    public List<ChatMessage> getRoomMessages(@PathVariable String roomId) {
        return messageRepository.findByRoomIdOrderByTimestampAsc(roomId);
    }
}
