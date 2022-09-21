package com.euphoria.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.euphoria.shop.entity.Order;
import com.euphoria.shop.entity.vo.OrderConfirmVo;
import com.euphoria.shop.entity.vo.OrderGenerateVo;
import com.euphoria.shop.entity.vo.OrderToConfirmVo;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author euphoria
 * @since 2022-08-17
 */
public interface OrderService extends IService<Order> {

    OrderConfirmVo confirmOrder(OrderToConfirmVo order);

    // 订单已确认，生成
    void generateOrder(Long userId, OrderGenerateVo generateVo) throws RemotingException, InterruptedException, MQClientException;

    void orderTimeOut(String body);
}
