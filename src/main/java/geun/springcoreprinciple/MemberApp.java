package geun.springcoreprinciple;

import geun.springcoreprinciple.member.Grade;
import geun.springcoreprinciple.member.Member;
import geun.springcoreprinciple.member.MemberService;
import geun.springcoreprinciple.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
