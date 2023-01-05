package jieun.placesback.chat.param;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageParam {
    long accountIdx;
    long groupIdx;
    String content;
    @JsonIgnore
    long timestamp;
}