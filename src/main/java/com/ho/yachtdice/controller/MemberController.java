package com.ho.yachtdice.controller;

import com.ho.yachtdice.DTO.LoginRequest;
import com.ho.yachtdice.DTO.NameRequest;
import com.ho.yachtdice.DTO.RegisterRequest;
import com.ho.yachtdice.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    @PostMapping("/register")
    public void register(@RequestBody RegisterRequest DTO)
    {
        memberService.createMember(DTO.getName(), DTO.getPassword());
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest DTO) {
        String Response = memberService.loginMember(DTO.getName(),DTO.getPassword());
        return Response;
    }
    @PostMapping("/alreadyusingname")
    public boolean alreadyUsingEmail(@RequestBody NameRequest DTO)
    {
        return memberService.alreadyUsingname(DTO.getName());
    }
}
