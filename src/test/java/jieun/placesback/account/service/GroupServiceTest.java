package jieun.placesback.account.service;

import jieun.placesback.account.entity.GroupEntity;
import jieun.placesback.account.param.GroupJoinParam;
import jieun.placesback.account.repository.GroupRepository;
import jieun.placesback.account.vo.GroupVo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
class GroupServiceTest {
    @InjectMocks
    GroupService groupService;
    @Mock
    GroupRepository groupRepository;

    @Test
    void join_group_with_group_and_group_idx_failure() throws Exception {
        // given,
        GroupJoinParam groupJoinParam = new GroupJoinParam();
        groupJoinParam.setGroupId("2");
        groupJoinParam.setCode("Dubrovnik");

        // when, no group
        lenient().when(groupRepository.findOneByGroupId(groupJoinParam.getGroupId())).thenReturn(null);

        // then, no group with code
        assertThrows(Exception.class, () -> groupService.joinGroup(groupJoinParam));
    }

    @Test
    void join_group_with_group_and_group_code_failure() throws Exception {
        // given,
        GroupJoinParam groupJoinParam = new GroupJoinParam();
        groupJoinParam.setGroupId("2");
        groupJoinParam.setCode("Dubrovnik");

        // when, wrong code
        GroupEntity groupEntity = GroupEntity.builder()
                .groupId("2")
                .code("london").build();
        lenient().when(groupRepository.findOneByGroupId(groupJoinParam.getGroupId())).thenReturn(groupEntity);

        // then, wrong code
        assertThrows(Exception.class, () -> groupService.joinGroup(groupJoinParam));
    }


    @Test
    void add_group_with_random_code() throws IOException {
        String groupName = "test";

        // when, random code (code is not empty)

        GroupVo groupVo = new GroupVo();
        // then,

//        assertEquals(groupVo, groupService.addGroup(groupName));

    }
}