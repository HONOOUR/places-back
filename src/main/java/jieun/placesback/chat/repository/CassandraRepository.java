package jieun.placesback.chat.repository;

import jieun.placesback.chat.entity.MessageEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.cassandra.core.CassandraOperations;

@Repository
public class CassandraRepository {
    private final CassandraOperations cassandraOperations;

    public CassandraRepository(CassandraOperations cassandraOperations) {
        this.cassandraOperations = cassandraOperations;
    }

    public void save(MessageEntity message) {
        cassandraOperations.insert(message);
    }
}