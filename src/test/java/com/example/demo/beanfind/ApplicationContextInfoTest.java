package com.example.demo.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.example.demo.AppConfig;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class); // ApplicationContext

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames(); // 모든 빈 이름 가져오기
        for (String beanDefinitionName : beanDefinitionNames) { // 모든 빈 이름 출력하기
            Object bean = ac.getBean(beanDefinitionName); // 빈 가져오기
            System.out.println("name = " + beanDefinitionName + " object = " + bean); // 빈 이름과 객체 출력하기
        }
    }

    @Test
    @DisplayName("애플리케이션션 빈 출력하기")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames(); // 모든 빈 이름 가져오기
        for (String beanDefinitionName : beanDefinitionNames) { // 모든 빈 이름 출력하기
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName); // 빈 정의 가져오기
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) { // 애플리케이션 빈만 출력하기
                Object bean = ac.getBean(beanDefinitionName); // 빈 가져오기
                System.out.println("name = " + beanDefinitionName + " object = " + bean); // 빈 이름과 객체 출력하기
            }
        }
    }
}
