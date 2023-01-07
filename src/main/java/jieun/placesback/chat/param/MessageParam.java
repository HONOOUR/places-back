package jieun.placesback.chat.param;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageParam {
    @JsonProperty("account_idx")
    long accountIdx;
    @JsonProperty("group_idx")
    long groupIdx;
    @JsonProperty("content")
    String content;
    @JsonIgnore
    long timestamp;
}