package jieun.placesback.chat.service;

import jieun.placesback.chat.param.MessageParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.Instant;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatMQService chatMQService;
    private final ChatCassandraService chatCassandraService;
    public void sendMessage(MessageParam messageParam) throws Exception {
        messageParam.setTimestamp(Instant.now().getEpochSecond());
        chatCassandraService.save(messageParam);
        chatMQService.publishDelivery(messageParam);
    }
}
