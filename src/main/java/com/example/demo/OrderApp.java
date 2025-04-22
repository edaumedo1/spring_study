package com.example.demo;

import com.example.demo.discount.order.Order;
import com.example.demo.discount.order.OrderService;
import com.example.demo.discount.order.OrderServiceImpl;
import com.example.demo.member.Grade;
import com.example.demo.member.Member;
import com.example.demo.member.MemberService;
import com.example.demo.member.MemberServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl(); // 회원 서비스 생성
        OrderService orderService = new OrderServiceImpl(); // 주문 서비스 생성

        Long memberId = 1L; // 회원 ID
        Member member = new Member(memberId, "memberA", Grade.VIP); // 회원 생성
        memberService.join(member); // 회원 가입

        Order order = orderService.createOrder(memberId, "itemA", 10000); // 주문 생성
        System.out.println("order = " + order); // 주문 정보 출력
        System.out.println("order = " + order.calculatePrice()); // 주문 정보 출력
    }
}
