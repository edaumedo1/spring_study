package com.example.demo.order;

import com.example.demo.discount.DiscountPolicy;
import com.example.demo.member.Member;
import com.example.demo.member.MemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository; // 회원 저장소
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) { // 생성자 주입
        this.memberRepository = memberRepository; // 회원 저장소 주입
        this.discountPolicy = discountPolicy; // 할인 정책 주입
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId); // 회원 정보 조회
        int discountPrice = discountPolicy.discount(member, itemPrice); // 할인 금액 계산

        return new Order(memberId, itemName, itemPrice, discountPrice); // 주문 생성
    }

    // 테스트용도
    public MemberRepository getMemberRepository() { // 회원 저장소 반환
        return memberRepository; // 회원 저장소 반환
    }

}
