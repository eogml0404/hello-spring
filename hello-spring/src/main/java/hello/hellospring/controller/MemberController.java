package hello.hellospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import hello.hellospring.service.MemberService;

@Controller
public class MemberController {
    private final MemberService memberService;

    //연결 시켜줌 Autowired (스프링 컨테이너에서 찾아옴)
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
