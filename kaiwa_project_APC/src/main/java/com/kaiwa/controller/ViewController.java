package com.kaiwa.controller;

import com.kaiwa.model.ChatRoom;
import com.kaiwa.repository.ChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class ViewController {

    @Autowired
    private ChatRoomRepository chatRoomRepository;

    @GetMapping("/view")
    public String index() {
        return "index"; // will render templates/index.html
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // will render templates/login.html
    }

    @GetMapping("/rooms")
    public String rooms() {
        return "rooms"; // renders templates/rooms.html
    }

    @GetMapping("/register")
    public String register() {
        return "register"; // will render templates/register.html
    }

    @GetMapping("/chat/{roomName}")
    public String chat(@PathVariable String roomName, Model model) {
        // Should validate room exists and get actual room ID
        Optional<ChatRoom> room = chatRoomRepository.findByName(roomName);
        if (room.isPresent()) {
            model.addAttribute("roomId", room.get().getId());
            model.addAttribute("roomName", roomName);
        }
        return "chat";
    }


}
