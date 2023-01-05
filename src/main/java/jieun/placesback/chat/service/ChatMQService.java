package jieun.placesback.chat.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jieun.placesback.chat.entity.MQMessageEntity;
import jieun.placesback.chat.param.MessageParam;
import jieun.placesback.chat.repository.MQRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatMQService {
    @Value("${spring.rabbitmq.chat.topic-exchange}")
    private String topicExchangeName;
    @Value("${spring.rabbitmq.chat.topic-key}")
    private String topicKey;
    private final MQRepository mqRepository;

    public void publishDelivery(MessageParam messageParam) throws JsonProcessingException {
        MQMessageEntity mqMessageEntity = new MQMessageEntity();
        mqMessageEntity.setSourceAccountIdx(messageParam.getAccountIdx());
        mqMessageEntity.setContent(messageParam.getContent());
        mqMessageEntity.setTimestamp(messageParam.getTimestamp());
        ObjectMapper objectMapper = new ObjectMapper();
        String contentsAsString = objectMapper.writeValueAsString(mqMessageEntity);
        String queueName = String.format(topicKey, messageParam.getGroupIdx());
        mqRepository.send(topicExchangeName, queueName, contentsAsString);
    }
}