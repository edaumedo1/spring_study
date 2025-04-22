package com.example.demo.member;

public class Member {
    private Long id; // 회원 ID
    private String name; // 회원 이름
    private Grade grade; // 회원 등급

    public Member(Long id, String name, Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public Long getId() {
        return id; 
    }

    public String getName() {
        return name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
