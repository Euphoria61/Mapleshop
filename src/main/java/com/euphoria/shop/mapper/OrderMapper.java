package com.euphoria.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.euphoria.shop.entity.Goods;
import com.euphoria.shop.entity.Order;
import com.github.yulichang.base.MPJBaseMapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author euphoria
 * @since 2022-08-17
 */

public interface OrderMapper extends MPJBaseMapper<Order> {
    int reduceGoodsStore();

}
