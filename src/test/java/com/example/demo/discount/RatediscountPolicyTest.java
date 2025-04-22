package com.example.demo.discount;

import com.example.demo.member.Grade;
import com.example.demo.member.Member;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import org.assertj.core.api.Assertions;

class RatediscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP 회원은 10% 할인 적용")
    void vip_o() {
        // given
        Member member = new Member(1L, "VIP Member", Grade.VIP);
        int price = 10000;

        // when
        int discount = discountPolicy.discount(member, price);

        // then
        Assertions.assertThat(discount).isEqualTo(1000); // 10% of 10000 is 1000
    }

    @Test
    @DisplayName("VIP 회원은 10% 할인 적용")
    void vip_x() {
        // given
        Member member = new Member(1L, "BASIC Member", Grade.BASIC);
        int price = 10000;

        // when
        int discount = discountPolicy.discount(member, price);

        // then
        Assertions.assertThat(discount).isEqualTo(0); // 10% of 10000 is 1000
    }

}