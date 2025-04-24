package com.example.demo.singleton;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.AppConfig;
import com.example.demo.member.MemberService;

public class SingletonTest {
    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig(); // AppConfig 객체 생성
        MemberService memberService1 = appConfig.memberService(); // memberService() 메서드 호출
        MemberService memberService2 = appConfig.memberService(); // memberService() 메서드 호출

        System.out.println("memberService1 = " + memberService1); // memberService1 출력
        System.out.println("memberService2 = " + memberService2); // memberService2 출력

        // memberService2 != memberService1
        assertThat(memberService1).isNotSameAs(memberService2); // memberService1과
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체")
    void singletonServiceTest() {
        SingletonService singletonService1 = SingletonService.getInstance(); // SingletonService 객체 생성
        SingletonService singletonService2 = SingletonService.getInstance(); // SingletonService 객체 생성

        System.out.println("singletonService1 = " + singletonService1); // singletonService1 출력
        System.out.println("singletonService2 = " + singletonService2); // singletonService2 출력

        // singletonService1 != singletonService2
        assertThat(singletonService1).isSameAs(singletonService2); // singletonService1과 singletonService2가 같은지 확인
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class); // ApplicationContext 객체 생성

        MemberService memberService1 = ac.getBean("memberService", MemberService.class); // memberService() 메서드 호출
        MemberService memberService2 = ac.getBean("memberService", MemberService.class); // memberService() 메서드 호출

        System.out.println("memberService1 = " + memberService1); // memberService1 출력
        System.out.println("memberService2 = " + memberService2); // memberService2 출력

        // memberService1 != memberService2
        assertThat(memberService1).isSameAs(memberService2); // memberService1과 memberService2가 같은지 확인
    }
}