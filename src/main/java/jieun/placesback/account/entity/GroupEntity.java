package jieun.placesback.account.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
public class GroupEntity {
    long groupIdx;
    String code;

    @Builder
    GroupEntity(long groupIdx, String code) {
        this.groupIdx = groupIdx;
        this.code = code;
    }
}
