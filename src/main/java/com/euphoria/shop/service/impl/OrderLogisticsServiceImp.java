package com.euphoria.shop.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.euphoria.shop.service.OrderLogisticsService;
import com.euphoria.shop.service.OrderService;
import com.euphoria.shop.entity.Order;
import com.euphoria.shop.entity.OrderLogistics;
import com.euphoria.shop.mapper.OrderLogisticsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author euphoria
 * @since 2022-08-17
 */
@Service
public class OrderLogisticsServiceImp extends ServiceImpl<OrderLogisticsMapper, OrderLogistics> implements OrderLogisticsService {
    @Lazy
    @Autowired
    private OrderService orderService;

    //发货
    @Override
    public int deliverGoods(OrderLogistics orderLogistics) {
        Long expressNo = IdUtil.getSnowflakeNextId();
        //更新物流单号
        int update = baseMapper.update(null, new UpdateWrapper<OrderLogistics>()
                .eq("order_logistics_id", orderLogistics.getOrderLogisticsId())
                .set("express_no", expressNo));
        //更新订单状态
        boolean update1 = orderService.update(new UpdateWrapper<Order>().eq("order_id", orderLogistics.getOrderId()).set("order_status", 1));
        if (update == 0 || !update1) return 0;
        return 1;
    }
}
