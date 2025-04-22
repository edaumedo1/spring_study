package com.example.demo.member;

public class MemberServiceImpl implements MemberService {
    
    private final MemberRepository memberRepository = new MemoryMemberRepository(); // 회원 저장소

    @Override
    public void join(Member member) { // 회원 가입
        memberRepository.save(member); // 회원 저장소에 회원 저장
    }

    @Override
    public Member findMember(Long memberId) { // 회원 조회
        return memberRepository.findById(memberId); // 회원 저장소에서 회원 조회
    }
}
