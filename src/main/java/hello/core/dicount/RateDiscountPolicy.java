package hello.core.dicount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicy implements discountPolicy{

    private int discountPer = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return price * discountPer / 100;
        }
        else {
            return 0;
        }
    }
}
