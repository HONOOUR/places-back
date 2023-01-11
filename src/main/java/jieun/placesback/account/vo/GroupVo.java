package jieun.placesback.account.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
public class GroupVo {
    @JsonProperty("group_idx")
    long groupIdx;
    String code;
    String name;

    @Builder
    public GroupVo(long groupIdx, String code, String name) {
        this.groupIdx = groupIdx;
        this.code = code;
        this.name = name;
    }
}
