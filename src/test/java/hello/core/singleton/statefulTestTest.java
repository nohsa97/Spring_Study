package hello.core.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class statefulTestTest {

    @Test
    void statefulServiceSingleTone() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        statefulTest bean1 = ac.getBean(statefulTest.class);
        statefulTest bean2 = ac.getBean(statefulTest.class);

        //a 사용자가 만원 주문 지역변수로 처리
        int price = bean1.order("아이스크림", 10000);

        //b사용자가 2만원 주문
        bean2.order("치킨",20000);

        //
        //int price = bean1.getPrice();
        //2만원이 출력됨
        System.out.println("price = " + price);

        //org.assertj.core.api.Assertions.assertThat(bean1.getPrice()).isEqualTo(20000);
        org.assertj.core.api.Assertions.assertThat(price).isEqualTo(10000);
    }

    static class TestConfig {
        @Bean
        public statefulTest statefulTestTest() {
            return new statefulTest();
        }
    }

}