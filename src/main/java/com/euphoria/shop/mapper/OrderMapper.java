package com.euphoria.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.euphoria.shop.entity.Order;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author euphoria
 * @since 2022-08-17
 */

public interface OrderMapper extends BaseMapper<Order> {
    int reduceGoodsStore();

}
