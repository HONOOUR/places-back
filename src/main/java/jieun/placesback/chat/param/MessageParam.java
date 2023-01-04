package jieun.placesback.chat.param;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageParam {
    long accountIdx;
    long groupId;
    String content;
}