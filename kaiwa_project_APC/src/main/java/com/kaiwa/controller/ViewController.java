package com.kaiwa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ViewController {

    @GetMapping("/")
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
        model.addAttribute("roomId", roomName); // inject room name into chat.html
        return "chat"; // renders templates/chat.html
    }

}
