package com.example.demo.xml;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.example.demo.member.MemberService;

import static org.assertj.core.api.Assertions.*;

public class xmlAppContext {
    @Test
    void xmlAppContext() {
        ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml"); // XML 파일을 읽어오는 ApplicationContext 생성
        MemberService memberService = ac.getBean("memberService", MemberService.class); // 빈 이름으로 조회
        assertThat(memberService).isInstanceOf(MemberService.class); // MemberService 타입으로 변환
    }
}
