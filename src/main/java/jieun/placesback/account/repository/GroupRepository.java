package jieun.placesback.account.repository;

import com.redis.om.spring.repository.RedisDocumentRepository;
import jieun.placesback.account.entity.GroupEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends RedisDocumentRepository<GroupEntity, Long> {

    GroupEntity findByGroupIdx(long groupIdx);
//    public GroupEntity findByGroupIdx(long groupIdx) {
//        // find redis key
//        return null;
//    }
//
//    public GroupVo save(GroupEntity groupEntity) {
//        // redis hash operation group idx ? - name, code
//    }
}
