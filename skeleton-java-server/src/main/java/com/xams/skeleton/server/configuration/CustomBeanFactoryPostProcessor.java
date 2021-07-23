package com.xams.skeleton.server.configuration;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        /*
         *   这里只允许进行操作 beanDefinitions，不能进行任何实例化操作！
         * */
        System.out.println("============================");
        System.out.println("CustomBeanFactoryPostProcessor 001");
        System.out.println("============================");
    }
}
