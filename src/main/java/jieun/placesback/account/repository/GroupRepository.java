package jieun.placesback.account.repository;

import jieun.placesback.account.entity.GroupEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends CrudRepository<GroupEntity, String>{

    GroupEntity findOneByGroupId(String groupId);
}
