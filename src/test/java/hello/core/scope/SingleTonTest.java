package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SingleTonTest {

    @Test
    void singletonBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SigletonBean.class);

        SigletonBean bean1 = ac.getBean(SigletonBean.class);
        SigletonBean bean2 = ac.getBean(SigletonBean.class);

        System.out.println("bean1 = " + bean1);
        System.out.println("bean2 = " + bean2);
        Assertions.assertThat(bean1).isSameAs(bean2);

        ac.close();
    }

    @Scope("singleton")
    static class SigletonBean {
        @PostConstruct
        public void init() {
            System.out.println("시작");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("끝");
       }
    }
}
