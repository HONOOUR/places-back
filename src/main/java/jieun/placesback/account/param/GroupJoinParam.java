package jieun.placesback.account.param;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupJoinParam {
    @JsonProperty("group_id")
    String groupId;
    String code;
}
