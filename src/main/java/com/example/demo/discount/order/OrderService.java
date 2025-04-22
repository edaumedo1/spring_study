package com.example.demo.discount.order;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice); // 주문 생성 (할인 없음)

}
