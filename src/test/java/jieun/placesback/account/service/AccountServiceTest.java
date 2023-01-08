package jieun.placesback.account.service;

import jieun.placesback.account.entity.GroupEntity;
import jieun.placesback.account.param.GroupJoinParam;
import jieun.placesback.account.repository.GroupRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {
    @InjectMocks
    AccountService accountService;
    @Mock
    GroupRepository groupRepository;

    @Test
    void join_with_group_and_group_idx_failure() throws Exception {
        // given,
        GroupJoinParam groupJoinParam = new GroupJoinParam();
        groupJoinParam.setGroupIdx(2);
        groupJoinParam.setCode("Dubrovnik");

        // when, no group
        lenient().when(groupRepository.findByGroupIdx(groupJoinParam.getGroupIdx())).thenReturn(null);

        // then,
        assertThrows(Exception.class, () -> accountService.joinGroup(groupJoinParam));
    }

    @Test
    void join_with_group_and_group_code_failure() throws Exception {
        // given,
        GroupJoinParam groupJoinParam = new GroupJoinParam();
        groupJoinParam.setGroupIdx(2);
        groupJoinParam.setCode("Dubrovnik");

        // when, wrong code
        GroupEntity groupEntity = GroupEntity.builder()
                .groupIdx(2)
                .code("london").build();
        lenient().when(groupRepository.findByGroupIdx(groupJoinParam.getGroupIdx())).thenReturn(groupEntity);

        // then,
        assertThrows(Exception.class, () -> accountService.joinGroup(groupJoinParam));
    }

}