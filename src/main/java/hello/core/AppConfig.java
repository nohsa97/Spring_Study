package hello.core;

import hello.core.dicount.discountPolicy;
import hello.core.dicount.fixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImple;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImple;

//의존성 주입
public class AppConfig {
    //환경 구성을 여기서 다한다.

    public MemberService memberService() {
        //앱컨피그를 통해 멤버를 부를때, 메모리 멤버 리포지토리가 여기서 생성
        return new MemberServiceImple(memberRepository());
        //기존에 쓰이던 방식
        //return new MemberServiceImple(new MemoryMemberRepository());
    }

    private MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImple(memberRepository(),
                discountPolicy());
    }

    private discountPolicy discountPolicy() {
        return new fixDiscountPolicy();
    }


}
