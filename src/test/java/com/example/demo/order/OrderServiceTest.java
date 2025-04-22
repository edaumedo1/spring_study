package com.example.demo.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.AppConfig;
import com.example.demo.member.Grade;
import com.example.demo.member.Member;
import com.example.demo.member.MemberService;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void BeforeEach() {
        AppConfig appConfig = new AppConfig(); // AppConfig 객체 생성
        memberService = appConfig.memberService(); // 회원 서비스 생성
        orderService = appConfig.orderService(); // 주문 서비스 생성
    }

    AppConfig appConfig = new AppConfig(); // AppConfig 객체 생성

    @Test
    void createOrder() {
        Long memberId = 1L; // 회원 ID
        Member member = new Member(memberId, "memberA", Grade.VIP); // 회원 생성
        memberService.join(member); // 회원 가입

        Order order = orderService.createOrder(memberId, "itemA", 10000); // 주문 생성
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000); // 할인 금액 검증

    }

}
