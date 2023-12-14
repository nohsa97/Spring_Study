package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {

    @Test
    @DisplayName("싱글톤x 순수")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        //서로 다른 인스턴스가 생성됨 할때마다 하면 엄청 많은 객체들이 생성 > 지옥
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        //1이랑 2랑 다른거임 .
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤")
    void singleTest() {
        Single single = Single.getInstance();
        Single single2 = Single.getInstance();

        //같은 객체 가르킴.
        System.out.println(single);
        System.out.println("single2 = " + single2);

        //isSameAs - ==
        //isEquls - equlas.
    }
    @Test
    @DisplayName("스프링 컨테이너")
    void springContainer() {
        //AppConfig appConfig = new AppConfig();
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);
        //싱글톤으로 만들어짐 그냥 컨테이너가 그렇게함 ㅇㅇ


        //MemberService memberService1 = appConfig.memberService();
       // MemberService memberService2 = appConfig.memberService();

        //서로 다른 인스턴스가 생성됨 할때마다 하면 엄청 많은 객체들이 생성 > 지옥
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        //1이랑 2랑 다른거임 .
        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }
}
