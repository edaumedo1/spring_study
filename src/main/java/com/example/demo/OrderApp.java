package com.example.demo;

import com.example.demo.member.Grade;
import com.example.demo.member.Member;
import com.example.demo.member.MemberService;
import com.example.demo.order.Order;
import com.example.demo.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig(); // AppConfig 객체 생성

        MemberService memberService = appConfig.memberService(); // 회원 서비스 생성
        OrderService orderService = appConfig.orderService(); // 주문 서비스 생성

        Long memberId = 1L; // 회원 ID
        Member member = new Member(memberId, "memberA", Grade.VIP); // 회원 생성
        memberService.join(member); // 회원 가입

        Order order = orderService.createOrder(memberId, "itemA", 10000); // 주문 생성
        System.out.println("order = " + order); // 주문 정보 출력
        System.out.println("order = " + order.calculatePrice()); // 주문 정보 출력
    }
}
