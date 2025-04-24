package com.example.demo.singleton;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.AppConfig;
import com.example.demo.member.MemberRepository;
import com.example.demo.member.MemberServiceImpl;
import com.example.demo.order.OrderServiceImpl;

public class ConfigurationSingletonTest {
    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class); // ApplicationContext 객체 생성

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class); // Member

        MemberRepository memberRepository1 = memberService.getMemberRepository(); // memberRepository() 메서드 호출
        MemberRepository memberRepository2 = orderService.getMemberRepository(); // memberRepository() 메서드 호출

        System.out.println("memberService = " + memberRepository1); // memberRepository1 출력
        System.out.println("orderService = " + memberRepository2); // memberRepository2 출력
        System.out.println("memberRepository = " + memberRepository); // memberRepository2 출력

        assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
    }

    @Test
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class); // ApplicationContext 객체 생성
        AppConfig bean = ac.getBean(AppConfig.class); // AppConfig 객체 생성

        System.out.println("bean = " + bean.getClass()); // AppConfig 객체의 클래스 출력
    }
}
