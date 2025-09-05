package com.kaiwa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/register")
    public String register() {
        return "register"; // will render templates/register.html
    }
}
