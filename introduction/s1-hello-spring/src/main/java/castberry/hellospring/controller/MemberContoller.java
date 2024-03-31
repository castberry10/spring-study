package castberry.hellospring.controller;

import castberry.hellospring.domain.Member;
import castberry.hellospring.sevice.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberContoller {
    private final MemberService memberService;

    @Autowired
    public MemberContoller(MemberService memberService) {
        this.memberService = memberService;
    }
}
