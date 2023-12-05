package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    //MemberService memberService = new MemberServiceImple();

    MemberService memberService;

    //테스트 실행전 무조건 실행됨
    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }
    @Test
    void join() {
        //given
        Member member = new Member(1L, "Ma", Grade.VIP);


        //when
        memberService.join(member);
        Member findM = memberService.findMember(1l);


        //then
        Assertions.assertThat(member).isEqualTo(findM);
    }
}
