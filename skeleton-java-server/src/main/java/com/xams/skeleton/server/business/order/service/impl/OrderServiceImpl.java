package com.xams.skeleton.server.business.order.service.impl;

import com.xams.skeleton.server.business.order.service.OrderService;
import com.xams.skeleton.server.business.cafeeine.CaffeineService;
import com.xams.skeleton.server.business.order.entity.Order;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
class OrderServiceImpl implements OrderService, InitializingBean, DisposableBean {

    @Autowired
    private CaffeineService caffeineService;


    @Override
    public Order view() {
        return new Order();
    }


    OrderServiceImpl() {
        System.out.println("============================");
        System.out.println("bean constructor 002");
        System.out.println("============================");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("============================");
        System.out.println("bean afterPropertiesSet 005");
        System.out.println("============================");
    }

    @PostConstruct
    public void init() {
        System.out.println("============================");
        System.out.println("bean init 004");
        System.out.println("============================");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("============================");
        System.out.println("bean destroy 007");
        System.out.println("============================");
    }
}
