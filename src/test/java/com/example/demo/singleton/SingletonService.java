package com.example.demo.singleton;

public class SingletonService {
    private static final SingletonService instance = new SingletonService(); // static으로 instance 생성

    public static SingletonService getInstance() { // static 메서드로 instance 반환
        return instance;
    }

    private SingletonService() { // private 생성자
    }

    public void logic() { // 비즈니스 로직
        System.out.println("싱글톤 객체 로직 호출");
    }
}