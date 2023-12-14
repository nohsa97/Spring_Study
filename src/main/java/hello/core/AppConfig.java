package hello.core;

import hello.core.dicount.RateDiscountPolicy;
import hello.core.dicount.discountPolicy;
import hello.core.dicount.fixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImple;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImple;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//configuration - 설정 정보
//메소드마다 bean이라고 적기.
//스프링 컨테이너에 등록됨

@Configuration
public class AppConfig {
    //환경 구성을 여기서 다한다.
    //스프링 빈

    //@Bean 1

    @Bean
    public MemberService memberService() {
        //앱컨피그를 통해 멤버를 부를때, 메모리 멤버 리포지토리가 여기서 생성
        return new MemberServiceImple(memberRepository());
        //기존에 쓰이던 방식
        //return new MemberServiceImple(new MemoryMemberRepository());
    }
    //스프링 빈
    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImple(memberRepository(),
                discountPolicy());
    }
    @Bean
    public discountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }


}
//스프링 빈 쓰면 좀더 귀찮아짐 왜 써야함?
// >> 많은 장점이 있다캄.