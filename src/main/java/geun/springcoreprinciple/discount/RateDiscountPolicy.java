package geun.springcoreprinciple.discount;

import geun.springcoreprinciple.member.Grade;
import geun.springcoreprinciple.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;           //10% 할인
    @Override
    public int discount(Member member, int price) {

        if(member.getGrade() == Grade.VIP){
            return price / discountPercent;
        }else{
            return 0;
        }
    }
}
