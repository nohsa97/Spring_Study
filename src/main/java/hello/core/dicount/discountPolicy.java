package hello.core.dicount;

import hello.core.member.Member;

public interface discountPolicy {

    // 할인된 금액 return
    int discount(Member member, int price);
}
