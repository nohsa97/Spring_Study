package hello.core.autoWired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(TestBean.class);

    }

    static class TestBean {
        @Autowired(required = false)
        public void setNoBean(Member mem1) {
            System.out.println("mem1 = " + mem1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member mem2) {
            System.out.println("mem2 = " + mem2);
        }

        @Autowired
        public void setNoBean3(Optional<Member> mem3) {
            System.out.println("mem3 = " + mem3);
        }
    }
}
