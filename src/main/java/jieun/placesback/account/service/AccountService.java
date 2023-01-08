package jieun.placesback.account.service;

import jieun.placesback.account.entity.GroupEntity;
import jieun.placesback.account.param.GroupJoinParam;
import jieun.placesback.account.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final GroupRepository groupRepository;

    public void joinGroup(GroupJoinParam groupJoinParam) throws Exception{
        GroupEntity groupEntity = groupRepository.findByGroupIdx(groupJoinParam.getGroupIdx());
        if (groupEntity != null) {
            if (groupJoinParam.getCode() == groupEntity.getCode()) {
                // return jwt header
            }
        }
        throw new Exception();
    }
}
