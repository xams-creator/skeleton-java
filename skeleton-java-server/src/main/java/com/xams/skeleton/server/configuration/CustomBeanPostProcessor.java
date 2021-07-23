package com.xams.skeleton.server.configuration;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("orderServiceImpl")) {
            System.out.println("============================");
            System.out.println("CustomBeanPostProcessor 003 before");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("orderServiceImpl")) {
            System.out.println("CustomBeanPostProcessor 006 after");
            System.out.println("============================");
        }
        return bean;
    }

}
