package com.example.demo.member;

public interface MemberRepository {
    void save(Member member); // 회원 저장

    Member findById(Long memberId); // 회원 조회
}
