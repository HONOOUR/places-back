package jieun.placesback.account.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@RedisHash("group")
public class GroupEntity {
    @Id @Indexed
    String groupId;
    @NonNull @Indexed
    String code;
    @NonNull
    String name;

    @Builder
    GroupEntity(String groupId, String code, String name) {
        this.groupId = groupId;
        this.code = code;
        this.name = name;
    }
}
