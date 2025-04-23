package beanfind;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.AppConfig;
import com.example.demo.member.MemberService;
import com.example.demo.member.MemberServiceImpl;

import static org.assertj.core.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class); // ApplicationContext

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class); // 빈 이름으로 조회
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class); // MemberService 타입으로 변환
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class); // 빈 이름으로 조회
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class); // MemberService 타입으로 변환
    }

    @Test
    @DisplayName("구체 타입으로만 조회")
    void findBeanByName2() {
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class); // 빈 이름으로 조회
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class); // MemberService 타입으로 변환
    }

    @Test
    @DisplayName("빈 타입으로 조회X")
    void findBeanByNameX() {
        assertThrows(NoSuchBeanDefinitionException.class, () -> ac.getBean("XXXXXXX", MemberService.class));
    }
}
