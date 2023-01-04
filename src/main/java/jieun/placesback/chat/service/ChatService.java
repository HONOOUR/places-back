package jieun.placesback.chat.service;

import jieun.placesback.chat.param.MessageParam;
import jieun.placesback.chat.vo.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.Instant;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatMQService chatMQService;
    private final ChatCassandraService chatCassandraService;
    public void sendMessage(MessageParam messageParam) throws Exception {
        Message message = new Message();
        message.setTimestamp(Instant.now().getEpochSecond());
        message.setAccountIdx(messageParam.getAccountIdx());
        message.setContent(messageParam.getContent());

        chatMQService.publishDelivery(message);
        chatCassandraService.save(message);
    }
}
