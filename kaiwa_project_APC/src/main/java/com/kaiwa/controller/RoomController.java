package com.kaiwa.controller;

import com.kaiwa.model.ChatRoom;
import com.kaiwa.repository.ChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @Autowired
    private ChatRoomRepository chatRoomRepository;

    @GetMapping
    public List<ChatRoom> getAllRooms() {
        return chatRoomRepository.findAll();
    }

//    list() {
//        return chatRoomRepository.findAll();
//    }

    @PostMapping
    public ResponseEntity<ChatRoom> create(@RequestBody ChatRoom room) {
//        return ResponseEntity.ok(chatRoomRepository.save(room));
        ChatRoom savedRoom = chatRoomRepository.save(room);
        return ResponseEntity.ok(savedRoom);
    }
}
