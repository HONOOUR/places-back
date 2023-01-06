package jieun.placesback.chat.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * permanent store
 * cassandra
 */
@Getter
@Setter
public class MessageEntity {
    long timestamp;
    long sourceIdx;
    long targetIdx;
    String content;
}