package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImple;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService1 = appConfig.memberService();
        //MemberService memberService = new MemberServiceImple();

        //appconfig 설정 정보를 가지고 스프링에 넣음
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService1 = applicationContext.getBean("memberService", MemberService.class);

        Member member1 = new Member(1L, "Noh", Grade.VIP);
        Member member2 = new Member(2L, "xx", Grade.BASIC);
        //memberService.join(member1);
        memberService1.join(member2);

        //Member findM = memberService.findMember(1l);
        Member findM1 = memberService1.findMember(2L);
        System.out.println("first : " + member1.getName());
        System.out.println("Finded : " + findM1.getName());
    }
}
