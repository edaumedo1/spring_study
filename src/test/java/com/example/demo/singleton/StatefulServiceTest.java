package com.example.demo.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class); // ApplicationContext 객체 생성
        StatefulService statefulService1 = ac.getBean(StatefulService.class); // StatefulService 객체 생성
        StatefulService statefulService2 = ac.getBean(StatefulService.class); // StatefulService 객체 생성

        int priceUserA = statefulService1.order("userA", 10000); // 사용자 A 주문
        int priceUserB = statefulService2.order("userB", 20000); // 사용자 B 주문

        // 사용자 A 주문 금액 조회
        // int price = statefulService1.getPrice(); // 사용자 A 주문 금액 조회
        System.out.println("price = " + priceUserA); // 사용자 A 주문 금액 출력

        assertThat(priceUserA).isEqualTo(10000); // 사용자 A 주문 금액이 20000인지 확인
        assertThat(priceUserB).isEqualTo(20000); // 사용자 A 주문 금액이 20000인지 확인
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService(); // StatefulService 객체 생성
        }
    }
}