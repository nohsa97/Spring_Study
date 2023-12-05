package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImple;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImple;

public class OrderApp {
    public static void main(String[] args) {
        //MemberService memberService = new MemberServiceImple();
        //OrderService orderService = new OrderServiceImple();
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId= 1L;
        Member a = new Member(memberId, "A", Grade.VIP);
        memberService.join(a);

        Order ord = orderService.createOrder(memberId,"itemA", 10000);

        System.out.println(ord);
        System.out.println(ord.calculatePrice());


    }
}
