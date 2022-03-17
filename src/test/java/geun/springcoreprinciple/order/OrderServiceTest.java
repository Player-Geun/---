package geun.springcoreprinciple.order;

import geun.springcoreprinciple.AppConfig;
import geun.springcoreprinciple.member.Grade;
import geun.springcoreprinciple.member.Member;
import geun.springcoreprinciple.member.MemberService;
import geun.springcoreprinciple.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {


    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long memberId = 1L;  // primitive 타입으로 선언하지 않는 이유 : null 값을 넣기 위해 for db
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

    // 단위테스트의 중요성, spring 같은 거 없이 순수한 java 코드로 이루어진 테스트트
}