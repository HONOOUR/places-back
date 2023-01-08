package jieun.placesback.account.repository;

import jieun.placesback.account.entity.GroupEntity;
import org.springframework.stereotype.Repository;

@Repository
public class GroupRepository {
    public GroupEntity findByGroupIdx(long groupIdx) {
        // find redis key
        return null;
    }

}
