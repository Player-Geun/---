package geun.springcoreprinciple.discount;

import geun.springcoreprinciple.member.Member;

public interface DiscountPolicy {

    // discount 얼만지 보여주기
    int discount(Member member, int price);
}
