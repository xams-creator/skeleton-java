package com.xams.skeleton.server;

import com.xams.skeleton.server.business.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RestController
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    /**
     *  Bean声明周期
     *
     *  BeanFactoryPostProcessor.postProcessBeanFactory
     *
     *  Bean Constructor
     *
     *  BeanPostProcessor.postProcessBeforeInitialization
     *
     *  Bean PostConstruct
     *
     *  Bean afterPropertiesSet
     *
     *  BeanPostProcessor.postProcessAfterInitialization
     *
     *  Bean destroy
     *
     * **/

    /**
     *  Filter Interceptor 正常处理顺序
     *
     *  1. user request
     *
     *  2. filter1 start
     *          > filter1 doFilter
     *              > filter2 start
     *                  > filter2 doFilter
     *                      > interceptor preHandle
     *                          > business process
     *                      > interceptor postHandle
     *                      > interceptor afterCompletion
     *              > filter2 end
     *     filter1  end
     *
     * **/

    @Autowired
    private OrderService service;

    @PostConstruct
    void init() {
        System.out.println("============================");
        System.out.println(service.view() + "execute...");
        System.out.println("============================");
    }

    @GetMapping("/order/{id}")
    public void order(@PathVariable("id") Long id) {
        System.out.println("============================");
        System.out.println(id);
        System.out.println("============================");
    }

}

