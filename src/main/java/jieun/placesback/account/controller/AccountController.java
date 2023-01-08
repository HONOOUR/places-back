package jieun.placesback.account.controller;

import jieun.placesback.account.param.GroupJoinParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class AccountController {
    @PostMapping("/join/group")
    void joinGroup(@RequestBody GroupJoinParam groupJoinParam) {

    }
}
