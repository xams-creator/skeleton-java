package com.xams.skeleton.server.business.order.service.impl;

import com.xams.skeleton.common.service.OrderService;
import com.xams.skeleton.server.entity.Order;
import org.springframework.stereotype.Service;

@Service
class OrderServiceImpl implements OrderService {

    @Override
    public Order view() {
        return new Order();
    }

}
