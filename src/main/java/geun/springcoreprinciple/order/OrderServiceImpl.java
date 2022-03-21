package geun.springcoreprinciple.order;

import geun.springcoreprinciple.discount.DiscountPolicy;
import geun.springcoreprinciple.discount.FixDiscountPolicy;
import geun.springcoreprinciple.member.Member;
import geun.springcoreprinciple.member.MemberRepositroy;
import geun.springcoreprinciple.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

//    @Autowired        필드 주입 DI 프레임워크가 없으면 아무것도 못함, 테스트 하기 힘듦
//    실제 코드와 관계없는 테스트 코드나 스프링 설정을 목적으로 하는 @Configuration 같은 곳에만 특별히 사용
    private final MemberRepositroy memberRepositroy;
    private final DiscountPolicy discountPolicy;

//    @Autowired        생성자가 딱 1개만 있으면 @Autowired 생략해도 자동 주입, 물론 스프링 빈에만 해당
    public OrderServiceImpl(MemberRepositroy memberRepositroy, DiscountPolicy discountPolicy) {
        this.memberRepositroy = memberRepositroy;
        this.discountPolicy = discountPolicy;
    }

//    @Autowired            수정자 주입(setter 주입) : 주입할 대상이 없어도 동작하게 하려면 Autowired(required = false)
//    public void setMemberRepositroy(MemberRepositroy memberRepositroy) {
//        this.memberRepositroy = memberRepositroy;
//    }
//
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        this.discountPolicy = discountPolicy;
//    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepositroy.findById(memberId);
        int discountPolicy = this.discountPolicy.discount(member, itemPrice);     // 단일 책임 원칙 잘지킨것 주문, 할인 분리

        return new Order(memberId, itemName, itemPrice, discountPolicy);
    }
}
