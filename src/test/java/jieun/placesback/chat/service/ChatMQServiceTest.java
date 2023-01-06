package jieun.placesback.chat.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jieun.placesback.chat.repository.MQRepository;
import jieun.placesback.chat.entity.MQMessageEntity;
import jieun.placesback.chat.param.MessageParam;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;

import static org.mockito.Mockito.doNothing;

@ExtendWith(MockitoExtension.class)
public class ChatMQServiceTest {
    @Mock
    private MQRepository mqRepository;

    @Test
    void send_message_delivery_with () throws JsonProcessingException {
        // given message
        long timestamp = Instant.now().getEpochSecond();
        long accountIdx = 1;
        long groupIdx = 1;
        String content = "hi";
        MessageParam messageParam = new MessageParam();
        messageParam.setTimestamp(timestamp);
        messageParam.setAccountIdx(accountIdx);
        messageParam.setGroupIdx(groupIdx);
        messageParam.setContent(content);

        // then
        MQMessageEntity mqMessageEntity = new MQMessageEntity();
        mqMessageEntity.setSourceAccountIdx(messageParam.getAccountIdx());
        mqMessageEntity.setContent(messageParam.getContent());
        mqMessageEntity.setTimestamp(messageParam.getTimestamp());
        ObjectMapper objectMapper = new ObjectMapper();
        String contentsAsString = objectMapper.writeValueAsString(mqMessageEntity);

        String path = String.format("topic", messageParam.getGroupIdx());
        doNothing().when(mqRepository).send("topicExchange", path, contentsAsString);
    }
}
