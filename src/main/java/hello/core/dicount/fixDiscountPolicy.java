package hello.core.dicount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class fixDiscountPolicy implements discountPolicy {

    private int DiscountFixPrice = 1000;
    @Override
    public int discount(Member member, int price) {
        //enum 타입은 == 쓰는게 맞음.
        if (member.getGrade() == Grade.VIP){
            return DiscountFixPrice;
        }
        else return 0;

    }
}
