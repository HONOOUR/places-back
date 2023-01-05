package jieun.placesback.chat.contoller;

import jieun.placesback.chat.param.MessageParam;
import jieun.placesback.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;

    @PostMapping("/chat/msg")
    void sendMessage(@RequestBody MessageParam messageParam) throws Exception {
        chatService.sendMessage(messageParam);
    }
}