package hello.core.dicount;

import hello.core.member.Grade;
import hello.core.member.Member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//ctrl + shift + t 테스트 케이스 제작
class RateDiscountPolicyTest {
    RateDiscountPolicy RDT = new RateDiscountPolicy();

    @Test
    @DisplayName("10프로할인 되어야함")
    void vip_o () {
        //given
        //CTRL + ALT + V 바로 생성
        Member xx = new Member(1L, "vipmem", Grade.VIP);

        //when
        int dis = RDT.discount(xx, 10000);

        //then
        //static import 체크해보기
        Assertions.assertThat(dis).isEqualTo(1000);
    }
}