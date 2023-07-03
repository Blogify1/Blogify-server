package com.blogifyserver.member;


import com.blogifyserver.entity.Member;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/member")
public class MemberController {
    final MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }

    @PostMapping("/signUp")
    public String signUp(Member member) {
        if (service.signUp(member)) {
            return "OK";
        } else {
            return "FALSE";
        }
    }

    @PostMapping("/emailCheck")
    public String emailCheck(@RequestBody String email) {
        if (service.emailCheck(email)) {
            return "OK";
        } else {
            return "FALSE";
        }
    }

    @PostMapping("/nickNameCheck")
    public String nickNameCheck(@RequestBody String nickName) {
        if (service.nickNameCheck(nickName)) {
            return "OK";
        } else {
            return "FALSE";
        }
    }

    @GetMapping("/remove")
    public String remove(){
        service.remove();
        return "cxc";
    }
}