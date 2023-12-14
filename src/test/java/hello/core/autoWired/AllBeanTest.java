package hello.core.autoWired;

import hello.core.AutoAppConfig;
import hello.core.dicount.discountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class AllBeanTest {

    @Test
    void findAllBean() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);

        DiscountService discountService = ac.getBean(DiscountService.class);
        Member mem = new Member(1L, "userA", Grade.VIP);
        int price = discountService.discount(mem,10000,"fixDiscountPolicy");
        assertThat(discountService).isInstanceOf(DiscountService.class);
        assertThat(price).isEqualTo(1000);
    }

    static class DiscountService {
        private final Map<String, discountPolicy> policyMap;
        private final List<discountPolicy> list;

        @Autowired
        public DiscountService(Map<String, discountPolicy> policyMap, List<discountPolicy> list) {
            this.policyMap = policyMap;
            this.list = list;
            System.out.println("policyMap = " + policyMap);
            System.out.println("list = " + list);
        }

        public int discount(Member mem, int price, String discountCode) {
            discountPolicy discountPolicy = policyMap.get(discountCode);
            return discountPolicy.discount(mem, price);
        }
    }
}
