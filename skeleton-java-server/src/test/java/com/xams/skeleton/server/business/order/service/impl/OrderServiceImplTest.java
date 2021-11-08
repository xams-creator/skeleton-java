package com.xams.skeleton.server.business.order.service.impl;

import com.xams.skeleton.server.business.order.service.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@DisplayName("订单测试")
@SpringBootTest
public class OrderServiceImplTest {


    @Autowired
    OrderService orderService;

    @DisplayName("订单详情")
    @Test
    public void viewTest() {
        System.out.println(orderService.view());
    }


}
