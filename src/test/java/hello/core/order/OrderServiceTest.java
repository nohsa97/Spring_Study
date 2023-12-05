package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImple;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    //MemberService memberService = new MemberServiceImple();
    //OrderService orderService = new OrderServiceImple();
    MemberService memberService;
    OrderService orderService;

    //테스트 실행전 무조건 실행됨
    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }



    @Test
    void createOrder() {
        Long memberId = 1L;
        Member AA = new Member(memberId, "A", Grade.VIP);
        memberService.join(AA);



        Order ord = orderService.createOrder(memberId,"치즈",10000);

        Assertions.assertThat(ord.getDiscountPrice()).isEqualTo(1000);
    }
}
