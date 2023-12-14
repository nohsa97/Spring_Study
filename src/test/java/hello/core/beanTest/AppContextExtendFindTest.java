package hello.core.beanTest;

import hello.core.dicount.RateDiscountPolicy;
import hello.core.dicount.discountPolicy;
import hello.core.dicount.fixDiscountPolicy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class AppContextExtendFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(testConfig.class);

    @Test
    @DisplayName("부모타입 조회")
    void findBeanParent() {

        assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(discountPolicy.class));
    }

    @Test
    @DisplayName("부모타입 이름 조회")
    void findBeanName() {
        discountPolicy rateDisPolicy = ac.getBean("rateDisPolicy", discountPolicy.class);
        assertThat(rateDisPolicy).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("부모타입으로 모두 조회")
    void findAllBeansParentType() {
        Map<String, discountPolicy> beansOfType = ac.getBeansOfType(discountPolicy.class);
        assertThat(beansOfType.size()).isEqualTo(2);
        for (String s : beansOfType.keySet()) {
            System.out.println("key : "+ s +" value : "+ beansOfType.get(s));
        }
    }

    @Test
    @DisplayName("오브젝트로 조회")
    void findAllBeansObject() {
        Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);

        for (String s : beansOfType.keySet()) {
            System.out.println("key : "+ s +" value : "+ beansOfType.get(s));
        }
    }

    @Configuration
    static class testConfig{

        @Bean
        public discountPolicy rateDisPolicy() {
            return new RateDiscountPolicy();
        }

        @Bean
        public discountPolicy fixDisPolicy() {
            return new fixDiscountPolicy();
        }

    }
}
