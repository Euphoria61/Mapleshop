package com.euphoria.shop.service.impl;

import com.euphoria.shop.mapper.GoodsMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;

@SpringBootTest
class GoodsServiceImpTest {
    @Autowired
    private GoodsMapper goodsMapper;

    @Test
    void addGoods() {
        String path = null;
        try {
            path = ResourceUtils.getURL("classpath:").getPath() + "static/picture/goodsPicture";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(path);
    }

    @Test
    void reduceStore() {
        //goodsMapper.reduceGoodsStore();
    }
}