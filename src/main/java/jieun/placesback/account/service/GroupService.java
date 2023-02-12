package jieun.placesback.account.service;

import jieun.placesback.account.entity.GroupEntity;
import jieun.placesback.account.param.GroupJoinParam;
import jieun.placesback.account.repository.GroupRepository;
import jieun.placesback.account.vo.GroupVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;
    private final GroupCodeGenerator groupCodeGenerator;

    public void joinGroup(GroupJoinParam groupJoinParam) throws Exception{
        GroupEntity groupEntity = groupRepository.findOneByGroupId(groupJoinParam.getGroupId());
        if (groupEntity != null) {
            if (groupJoinParam.getCode() == groupEntity.getCode()) {
                // return jwt header
                // be able to chat
            }
        } else {
            throw new Exception();
        }
    }

    public GroupVo addGroup(String groupName) throws IOException {
        GroupEntity groupEntity = GroupEntity.builder()
                .code(groupCodeGenerator.getGroupCode())
                .name(groupName)
                .build();
        groupEntity = groupRepository.save(groupEntity);
        GroupVo groupVo = GroupVo.builder()
                .groupIdx(groupEntity.getGroupId())
                .code(groupEntity.getCode())
                .name(groupEntity.getName())
                .build();

        return groupVo;
    }
}