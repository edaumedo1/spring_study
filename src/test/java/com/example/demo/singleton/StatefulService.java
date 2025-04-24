package com.example.demo.singleton;

public class StatefulService {
    // private int price; // 가격 필드

    public int order(String name, int price) { // 주문 메서드
        System.out.println("name = " + name + " price = " + price); // 이름과 가격 출력
        // this.price = price; // 가격 필드에 가격 저장
        return price; // 가격 필드 반환
    }

    // public int getPrice() { // 가격 조회 메서드
    // return price; // 가격 필드 반환
    // }
}
