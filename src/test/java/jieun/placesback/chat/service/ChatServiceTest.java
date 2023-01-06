package jieun.placesback.chat.service;

import jieun.placesback.chat.param.MessageParam;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("ChatService test")
class ChatServiceTest {

    @InjectMocks
    ChatService chatService;
    @Mock
    ChatMQService chatMQService;
    @Mock
    ChatCassandraService chatCassandraService;

    @Test
    void send_message_with_the_same_accountId_messageId_failure() throws Exception {
        // given message with created msg id
        long accountIdx = 1;
        long groupIdx = 1;

        MessageParam messageParam = new MessageParam();
        messageParam.setAccountIdx(accountIdx);
        messageParam.setGroupIdx(groupIdx);
        messageParam.setContent("hello.");
        messageParam.setTimestamp(Instant.now().getEpochSecond());


        // when send to MQ, cass (already has the same id, and account idx
        lenient().doNothing().when(chatMQService).publishDelivery(messageParam);
        lenient().doThrow(Exception.class).when(chatCassandraService).save(messageParam);

        // then no same message id is allowed
        assertThrows(Exception.class, () -> chatService.sendMessage(messageParam));
    }

}