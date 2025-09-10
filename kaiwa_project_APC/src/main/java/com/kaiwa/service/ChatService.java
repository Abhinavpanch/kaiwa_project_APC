import com.kaiwa.model.ChatMessage;
import com.kaiwa.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ChatService {
    @Autowired
    private ChatMessageRepository messageRepository;

    public ChatMessage saveMessage(ChatMessage message) {
        message.setTimestamp(Instant.now());
        return messageRepository.save(message);
    }

    public List<ChatMessage> getRoomMessages(String roomId) {
        return messageRepository.findByRoomIdOrderByTimestampAsc(roomId);
    }
}
