package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanDefinitionTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class); // ApplicationContext

    @Test
    @DisplayName("빈 설정 메타정보 확인")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames(); // 모든 빈 이름 가져오기
        for (String beanDefinitionName : beanDefinitionNames) { // 모든 빈 이름 출력하기
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName); // 빈 가져오기

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) { // 애플리케이션 빈만 출력하기
                System.out.println("name = " + beanDefinitionName + " object = " + beanDefinition); // 빈 이름과 객체 출력하기
            }
        }
    }
}
