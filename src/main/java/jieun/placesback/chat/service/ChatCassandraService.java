package jieun.placesback.chat.service;

import jieun.placesback.chat.entity.MessageEntity;
import jieun.placesback.chat.param.MessageParam;
import jieun.placesback.chat.repository.CassandraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class ChatCassandraService {
    private final CassandraRepository cassandraRepository;

    public void save(MessageParam message) throws Exception {
        MessageEntity messageEntity = MessageEntity.builder()
                .targetIdx(message.getGroupIdx())
                .sourceIdx(message.getAccountIdx())
                .timestamp(Instant.ofEpochMilli(message.getTimestamp()))
                .content(message.getContent()).build();
        cassandraRepository.save(messageEntity);
    }
}
