package jieun.placesback.chat.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {
    long timestamp;
    long accountIdx;
    String content;
}