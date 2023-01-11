package jieun.placesback.account.entity;

import com.redis.om.spring.annotations.Document;
import com.redis.om.spring.annotations.Indexed;
import lombok.Builder;
import lombok.Generated;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Getter
@RedisHash("group")
@Document
public class GroupEntity {
    @Id @Generated
    long groupIdx;
    @Indexed @NonNull
    String code;
    @Indexed @NonNull
    String name;

    @Builder
    GroupEntity(long groupIdx, String code, String name) {
        this.groupIdx = groupIdx;
        this.code = code;
        this.name = name;
    }
}
