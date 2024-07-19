package com.xams.skeleton.server;

import com.xams.skeleton.server.business.order.service.OrderService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.datasource.AbstractDataSource;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.LinkedHashMap;
import java.util.Map;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@RestController
public class Application {

    public static void main(String[] args) {
//        DisposableBean

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
     * Filter Interceptor 正常处理顺序
     * <p>
     * 1. user request
     * <p>
     * 2. filter1 start
     * > filter1 doFilter
     * > filter2 start
     * > filter2 doFilter
     * > interceptor preHandle
     * > business process
     * > interceptor postHandle
     * > interceptor afterCompletion
     * > filter2 end
     * filter1  end
     **/

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

    @PostMapping("/test")
    public Map test(@RequestBody TestCommand command) {
        System.out.println("============================");
        System.out.println(command);
        Instant instant = Instant.ofEpochMilli(command.getExpireAt());
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        System.out.println("============================");
        Map map = new LinkedHashMap();
        map.put("time", localDateTime);
        return map;
    }
}

