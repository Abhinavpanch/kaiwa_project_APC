package com.kaiwa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.kaiwa.model.ChatRoom;
import com.kaiwa.repository.ChatRoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KaiwaApplication {
    public static void main(String[] args) {
        SpringApplication.run(KaiwaApplication.class, args);
    }

}
