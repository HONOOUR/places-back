package jieun.placesback.account.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
public class GroupVo {
    @JsonProperty("group_idx")
    String groupIdx;
    @JsonProperty
    String code;
    @JsonProperty
    String name;

    @Builder
    public GroupVo(String groupIdx, String code, String name) {
        this.groupIdx = groupIdx;
        this.code = code;
        this.name = name;
    }
}
