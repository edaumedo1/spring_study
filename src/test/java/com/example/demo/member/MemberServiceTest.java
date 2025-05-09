package com.example.demo.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.AppConfig;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void BeforeEach() {
        AppConfig appConfig = new AppConfig(); // AppConfig 객체 생성
        memberService = appConfig.memberService(); // 회원 서비스 생성
    }

    @Test
    void join() {
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then
        Assertions.assertThat(member).isEqualTo(findMember);

    }
}
