package geun.springcoreprinciple.order;

import geun.springcoreprinciple.discount.DiscountPolicy;
import geun.springcoreprinciple.discount.FixDiscountPolicy;
import geun.springcoreprinciple.member.Member;
import geun.springcoreprinciple.member.MemberRepositroy;
import geun.springcoreprinciple.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepositroy memberRepositroy = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepositroy.findById(memberId);
        int discountPolicy = this.discountPolicy.discount(member, itemPrice);     // 단일 책임 원칙 잘지킨것 주문, 할인 분리

        return new Order(memberId, itemName, itemPrice, discountPolicy);
    }
}
