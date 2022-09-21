package com.euphoria.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.euphoria.shop.entity.OrderLogistics;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author euphoria
 * @since 2022-08-17
 */
public interface OrderLogisticsService extends IService<OrderLogistics> {
    //发货
    int deliverGoods(OrderLogistics orderLogistics);

}
