package jieun.placesback.chat.service;

import jieun.placesback.chat.param.MessageParam;
import jieun.placesback.chat.vo.Message;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
        long msgId = 1;
        long accountIdx = 1;
        Message message = new Message();
        message.setTimestamp(msgId);
        message.setAccountIdx(accountIdx);

        // when send to MQ, cass (already has the same id, and account idx
        lenient().doNothing().when(chatMQService).publishDelivery(message);
        lenient().doThrow(Exception.class).when(chatCassandraService).save(message);

        // then no same message id is allowed
        MessageParam messageParam = new MessageParam();
        messageParam.setAccountIdx(accountIdx);
        messageParam.setContent("hello.");
        assertThrows(Exception.class, () -> chatService.sendMessage(messageParam));
    }

}