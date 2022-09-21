package com.euphoria.shop.service.impl;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.euphoria.shop.service.OrderService;
import com.euphoria.shop.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderServiceImpTest {

    @Autowired
    private OrderService orderService;

    @Test
    void generateOrder() {
        System.out.println(DateUtil.now());

    }
}