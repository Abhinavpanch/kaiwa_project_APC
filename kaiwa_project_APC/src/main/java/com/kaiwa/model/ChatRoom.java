package com.kaiwa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;import jakarta.validation.constraints.NotBlank;import com.kaiwa.validation.WordCount;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "rooms")
public class ChatRoom {
    @Id
    private String id;
    @NotBlank(message = "room name must not be blank")   private String name;
    private String description;
}
