package jieun.placesback.chat.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MQRepository {
    private final RabbitTemplate rabbitTemplate;
    public void send(String topicExchange, String queueName, String contents) {
        rabbitTemplate.convertAndSend(topicExchange, queueName, contents);
    }
}