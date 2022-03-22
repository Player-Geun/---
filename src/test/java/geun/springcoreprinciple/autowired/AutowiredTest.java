package geun.springcoreprinciple.autowired;

import geun.springcoreprinciple.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void autowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {

        // Member 는 스프릥 빈이 아님 -> required = false 라서 호출 자체가 안됨
        @Autowired(required = false)
        public void setNoBean1(Member member) {
            System.out.println("setNoBean1 = " + member);
        }

        // Null 호출
        // @Nullable : 자동 주입 대상이 없으면 오류가 발생
        @Autowired
        public void setNoBean2(@Nullable Member member) {
            System.out.println("setNoBean2 = " + member);
        }

        // Optional.empty 호출
        // 자동 주입 대상이 없으면 Optional.empty 가 입력됨
        @Autowired(required = false)
        public void setNoBean3(Optional<Member> member) {
            System.out.println("setNoBean3 = " + member);
        }

        // @Nullable과 Optional은 스프링 전반에 걸쳐서 지원된다
    }
}
