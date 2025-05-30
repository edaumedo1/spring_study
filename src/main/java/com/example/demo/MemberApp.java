package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.member.Grade;
import com.example.demo.member.Member;
import com.example.demo.member.MemberService;

public class MemberApp {
    public static void main(String[] args) {
        // AppConfig appConfig = new AppConfig(); // AppConfig 객체 생성
        // MemberService memberService = appConfig.memberService(); // 회원 서비스 생성

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); // ApplicationContext
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class); // 회원 서비스 생성

        Member member = new Member(1L, "memberA", Grade.VIP); // 회원 생성
        memberService.join(member); // 회원 가입
        Member findMember = memberService.findMember(1L); // 회원 조회
        System.out.println("new member = " + member.getName()); // 가입한 회원 이름 출력
        System.out.println("find member = " + findMember.getName()); // 조회한 회원 이름 출력

    }
}
