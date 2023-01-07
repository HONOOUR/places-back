package jieun.placesback.chat.service;

import jieun.placesback.chat.entity.MessageEntity;
import jieun.placesback.chat.param.MessageParam;
import jieun.placesback.chat.repository.CassandraRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
public class ChatCassandraServiceTest {
    @Mock
    CassandraRepository cassandraRepository;
    @InjectMocks
    ChatCassandraService chatCassandraService;

    @Test
    void save_message_to_cassandra () {
        // given
        MessageParam messageParam = new MessageParam();
        messageParam.setGroupIdx(1);
        messageParam.setAccountIdx(1);
        messageParam.setTimestamp(Instant.now().getEpochSecond());
        // when
        MessageEntity message = MessageEntity.builder()
                .targetIdx(messageParam.getGroupIdx())
                .sourceIdx(messageParam.getAccountIdx())
                .timestamp(Instant.ofEpochMilli(messageParam.getTimestamp())).build();
        doThrow().when(cassandraRepository).save(message);
        // then
        assertThrows(Exception.class, () -> chatCassandraService.save(messageParam));
    }
}