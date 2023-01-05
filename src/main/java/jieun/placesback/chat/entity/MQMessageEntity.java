package jieun.placesback.chat.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MQMessageEntity {
    long sourceAccountIdx;
    String content;
    long timestamp;
}
