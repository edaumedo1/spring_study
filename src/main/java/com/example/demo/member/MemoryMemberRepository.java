package com.example.demo.member;

import java.util.HashMap; // HashMap 클래스 import
// import java.util.concurrent.ConcurrentHashMap; // 동시접속시 변경해야함
import java.util.Map;


public class MemoryMemberRepository implements MemberRepository {
    private static Map<Long, Member> store = new HashMap<>(); // 회원 저장소
    // private static long sequence = 0L; // 회원 ID 생성기

    @Override
    public void save(Member member) {
        // member.setId(++sequence); // ID 생성
        store.put(member.getId(), member); // 회원 저장
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId); // 회원 조회
    }

}
