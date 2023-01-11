package jieun.placesback.account.controller;

import jieun.placesback.account.param.GroupJoinParam;
import jieun.placesback.account.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class AccountController {
    private final GroupService groupService;

    @PostMapping("/join/group")
    void joinGroup(@RequestBody GroupJoinParam groupJoinParam) {

    }

    /**
     * this controller is restricted.
     * and authorized host
     */
    @PostMapping("/group/{name}")
    void addGroup(@RequestParam String groupName) throws IOException {
        groupService.addGroup(groupName);
    }
}
