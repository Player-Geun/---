package geun.springcoreprinciple;

import geun.springcoreprinciple.member.Grade;
import geun.springcoreprinciple.member.Member;
import geun.springcoreprinciple.member.MemberService;
import geun.springcoreprinciple.member.MemberServiceImpl;
import geun.springcoreprinciple.order.Order;
import geun.springcoreprinciple.order.OrderService;
import geun.springcoreprinciple.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 1000);

        System.out.println("order = " + order);
    }
}
