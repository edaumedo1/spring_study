package beanfind;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.member.MemberRepository;
import com.example.demo.member.MemoryMemberRepository;

public class ApplicationContextSameBeanFindeTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class); // ApplicationContext

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 중복 오류가 발생한다.")
    void findBeanByTypeDuplicate() {
        assertThrows(NoUniqueBeanDefinitionException.class, () -> ac.getBean(MemberRepository.class)); // MemberRepository
    }

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 빈 이름을 지정하면 된다.")
    void findBeanByName() {
        MemberRepository memberRepository = ac.getBean("memberService1", MemberRepository.class); // 빈 이름으로 조회
        assertThat(memberRepository).isInstanceOf(MemberRepository.class); // MemberRepository 타입으로 변환

    }

    @Test
    @DisplayName("특정 타입을 모두 조회하기")
    void findAllBeanByType() {
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class); // 모든 MemberRepository
                                                                                               // 타입의 빈 조회
        for (String key : beansOfType.keySet()) { // 모든 빈 이름 출력하기
            System.out.println("key = " + key + " value = " + beansOfType.get(key)); // 빈 이름과 객체 출력하기
        }
        System.out.println("beansOfType = " + beansOfType); // 모든 빈 이름과 객체 출력하기
        assertThat(beansOfType.size()).isEqualTo(2); // 모든 빈 이름과 객체 개수 확인하기
    }

    @Configuration
    static class SameBeanConfig {
        @Bean
        public MemberRepository memberService1() {
            return new MemoryMemberRepository(); // 회원 서비스 생성
        }

        @Bean
        public MemberRepository memberService2() {
            return new MemoryMemberRepository(); // 회원 서비스 생성
        }
    }
}
