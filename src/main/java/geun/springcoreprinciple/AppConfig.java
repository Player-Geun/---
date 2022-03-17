package geun.springcoreprinciple;

import geun.springcoreprinciple.discount.DiscountPolicy;
import geun.springcoreprinciple.discount.FixDiscountPolicy;
import geun.springcoreprinciple.discount.RateDiscountPolicy;
import geun.springcoreprinciple.member.MemberRepositroy;
import geun.springcoreprinciple.member.MemberService;
import geun.springcoreprinciple.member.MemberServiceImpl;
import geun.springcoreprinciple.member.MemoryMemberRepository;
import geun.springcoreprinciple.order.OrderService;
import geun.springcoreprinciple.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepositroy memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

    // 메서드 명을 보면 역할이 다 들어남남
}
