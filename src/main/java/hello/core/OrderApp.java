package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImple;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImple;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
        //MemberService memberService = new MemberServiceImple();
        //OrderService orderService = new OrderServiceImple();
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();
        //OrderService orderService = appConfig.orderService();
        //스프링 컨테이너 APPCONTEXT는 인터페이스다
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Long memberId= 1L;
        Member a = new Member(memberId, "A", Grade.VIP);
        memberService.join(a);

        Order ord = orderService.createOrder(memberId,"itemA", 10000);

        System.out.println(ord);
        System.out.println(ord.calculatePrice());


    }
}

// appcontext를 스프링 컨테이너라함