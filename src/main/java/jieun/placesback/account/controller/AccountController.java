package jieun.placesback.account.controller;

import jieun.placesback.account.param.GroupJoinParam;
import jieun.placesback.account.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class AccountController {
    private final GroupService groupService;

    @PostMapping("/join/group")
    ResponseEntity<?> joinGroup(@RequestBody GroupJoinParam groupJoinParam) throws Exception {
        groupService.joinGroup(groupJoinParam);
        return ResponseEntity.ok().build();
    }

    /**
     * this controller is restricted.
     * and authorized host
     */
    @PostMapping("/group/{name}")
    ResponseEntity<?> addGroup(@PathVariable String name) throws IOException {
        return ResponseEntity.ok(groupService.addGroup(name));
    }
}
