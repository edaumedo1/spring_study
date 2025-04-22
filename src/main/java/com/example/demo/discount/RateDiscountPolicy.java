package com.example.demo.discount;

import com.example.demo.member.Grade;
import com.example.demo.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10; // 할인 비율 (10%)

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100; // VIP 회원에게 할인 비율 적용
        } else {
            return 0; // 일반 회원에게는 할인 없음
        }
    }

}
