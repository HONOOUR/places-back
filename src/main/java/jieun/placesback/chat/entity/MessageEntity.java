package jieun.placesback.chat.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.*;

import java.time.Instant;

/**
 * permanent store
 * cassandra
 */
@Getter
@Setter
@Table(value = "message")
public class MessageEntity {
    @PrimaryKeyColumn(name="target_idx", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    @CassandraType(type = CassandraType.Name.BIGINT)
    private long targetIdx;
    @PrimaryKeyColumn(name="timestamp", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    @CassandraType(type = CassandraType.Name.TIMESTAMP)
    private Instant timestamp;
    @Column(value = "source_idx")
    private long sourceIdx;
    @Column(value = "content")
    private String content;

    @Builder
    MessageEntity(long targetIdx, Instant timestamp, long sourceIdx, String content) {
        this.targetIdx = targetIdx;
        this.timestamp = timestamp;
        this.sourceIdx = sourceIdx;
        this.content = content;
    }
}