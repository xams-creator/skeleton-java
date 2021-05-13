package com.xams.skeleton;

import com.xams.skeleton.common.service.OrderService;
import com.xams.skeleton.server.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl();
    }

    @Autowired
    private OrderService service;

    @PostConstruct
    void init() {
        System.out.println(service.view());
    }

    static class OrderServiceImpl implements OrderService {

        @Override
        public Order view() {
            return new Order();
        }

    }
}

