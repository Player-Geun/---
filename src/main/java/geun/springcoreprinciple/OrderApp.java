package geun.springcoreprinciple;

import geun.springcoreprinciple.member.Grade;
import geun.springcoreprinciple.member.Member;
import geun.springcoreprinciple.member.MemberService;
import geun.springcoreprinciple.member.MemberServiceImpl;
import geun.springcoreprinciple.order.Order;
import geun.springcoreprinciple.order.OrderService;
import geun.springcoreprinciple.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 1000);

        System.out.println("order = " + order);
    }
}
