package com.euphoria.shop.entity.vo;

import com.euphoria.shop.entity.Goods;
import com.euphoria.shop.entity.Order;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author: Euphoria
 * @description: TODO
 * @date: 2022/12/8 12:25
 */
@Getter
@Setter

public class OrderVo {
    private int currentPage;
    private int pageSize;
    private long total;
    private List<OrderToVo> orderList;
}
