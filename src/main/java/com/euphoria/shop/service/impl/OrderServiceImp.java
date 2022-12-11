package com.euphoria.shop.service.impl;

import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.euphoria.shop.entity.*;
import com.euphoria.shop.entity.vo.*;
import com.euphoria.shop.service.*;
import com.euphoria.shop.mapper.OrderMapper;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import org.apache.rocketmq.client.exception.MQClientException;
//import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author euphoria
 * @since 2022-08-17
 */
@Service
public class OrderServiceImp extends ServiceImpl<OrderMapper, Order> implements OrderService {
    public static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImp.class);
    @Resource
    private UserAddressService userAddressService;
    @Resource
    private OrderDetailsService orderDetailsService;

    @Resource
    private GoodsService goodsService;
    @Resource
    private OrderLogisticsService orderLogisticsService;

//
//    @Resource
//    private DefaultMQProducer defaultMQProducer;

    //订单信息待确认
    @Override
    public OrderConfirmVo confirmOrder(OrderToConfirmVo order) {
        List<UserAddress> userAddresses = userAddressService.listUserAddress(order.getUserId());
        OrderConfirmVo orderConfirmVo = new OrderConfirmVo();
        BeanUtils.copyProperties(order, orderConfirmVo);
        orderConfirmVo.setUserAddress(userAddresses);
        return orderConfirmVo;
    }

    // 订单已确认，生成
    @Override
    public void generateOrder(Long userId, OrderGenerateVo generateVo) {
        //生成订单号
        Long orderno = IdUtil.getSnowflakeNextId();
        //订单主表插入
        Order order = new Order();
        BeanUtils.copyProperties(generateVo, order);
        order.setOrderNo(orderno);
        order.setUserId(userId);
//        order.setShopId(generateVo.getShop().getShopId());
        boolean insert = this.save(order);
        Long orderId = order.getOrderId();
        //订单明细表
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setOrderId(orderId);
        orderDetails.setGoodsId(generateVo.getGoodsId());
        orderDetails.setOrderPrice(order.getOrderAmountTotal());
        orderDetails.setOrderCount(order.getGoodsCount());
        orderDetails.setGoodsPrice(order.getGoodsAmountTotal());
        orderDetails.setGoodsName(generateVo.getGoodsName());
        orderDetails.setRemark(generateVo.getRemark());
        orderDetailsService.getBaseMapper().insert(orderDetails);
        //
//        OrderLogistics orderLogistics = new OrderLogistics();
//        orderLogistics.setConsigneeAddress(generateVo.getOrderAddress());
//        orderLogistics.setOrderId(orderId);
//        orderLogistics.setConsigneeTelephone(generateVo.getTelephone());
//        orderLogistics.setConsigneeName(generateVo.getRealName());
//        orderLogistics.setConsigneeAddress(generateVo.getOrderAddress());
//        orderLogistics.setConsigneeTelephone(generateVo.getTelephone());
//        // rocketmq实现订单超时取消
//        Message sendMsg = new Message("order", "generateOrder", JSON.toJSONBytes(orderLogistics));
//        //"1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h"
//        //生产者延时发送
//        sendMsg.setDelayTimeLevel(3);
//        defaultMQProducer.send(sendMsg, new SendCallback() {
//            //消息发送成功回调
//            @Override
//            public void onSuccess(SendResult sendResult) {
//                LOGGER.info("成功发送{}", sendResult);
//            }
//
//            //消息异常回调
//            @Override
//            public void onException(Throwable e) {
//                e.printStackTrace();
//                //补偿机制，根据业务情况进行使用，看是否进行重试
//            }
//        });

    }
//
//    @Override
//    public void orderTimeOut(String body) {
//        //订单超时取消
//            //判空异常处理
//            //   if(!body.isEmpty() && )
//            OrderLogistics order = JSON.parseObject(body, OrderLogistics.class);
//            int status = baseMapper.selectOne(new QueryWrapper<Order>().eq("order_id", order.getOrderId())).getOrderStatus();
//            //未付款订单取消
//            if (status == 0) {
//                OrderDetails orderDetails = orderDetailsService.getBaseMapper().selectOne(
//                        new QueryWrapper<OrderDetails>().eq("order_id", order.getOrderId()));
//                goodsService.incrGoodsStore(orderDetails.getGoodsId(), orderDetails.getOrderCount());
//                baseMapper.deleteById(order);
//                orderDetailsService.remove(new QueryWrapper<OrderDetails>().eq("order_id", order.getOrderId()));
//                LOGGER.info("订单超时取消成功");
//            }
//            //订单物流表插入
//            orderLogisticsService.save(order);
//        }

    @Override
    public OrderVo selectOrder(int currentPage, int pageSize) {
        IPage<OrderToVo> orderPage = baseMapper.selectJoinPage(new Page<>(currentPage, pageSize), OrderToVo.class,
                new MPJLambdaWrapper<OrderToVo>().select(Order::getOrderNo,Order::getOrderStatus,Order::getGoodsCount,Order::getGoodsAmountTotal,Order::getCreateTime)
                        .select(OrderDetails::getGoodsId,OrderDetails::getGoodsName)
                        .leftJoin(OrderDetails.class,OrderDetails::getOrderId ,Order::getOrderId)

        );
        OrderVo orderVo = new OrderVo();
        orderVo.setCurrentPage(currentPage);
        orderVo.setPageSize(pageSize);
        orderVo.setOrderList(orderPage.getRecords());
        orderVo.setTotal(orderPage.getTotal());

        return orderVo;
    }

    @Override
    public OrderVo selectOrderByUserId(Long userId, int currentPage, int pageSize) {
        IPage<OrderToVo> orderPage = baseMapper.selectJoinPage(new Page<>(currentPage, pageSize), OrderToVo.class,
                new MPJLambdaWrapper<OrderToVo>().select(Order::getUserId,Order::getOrderStatus,Order::getGoodsCount,Order::getGoodsAmountTotal,Order::getCreateTime)
                        .select(OrderDetails::getGoodsId,OrderDetails::getGoodsName)
                        .leftJoin(OrderDetails.class,OrderDetails::getOrderId ,Order::getOrderId)
                        .eq(Order::getUserId, userId)
        );
        OrderVo orderVo = new OrderVo();
        orderVo.setCurrentPage(currentPage);
        orderVo.setPageSize(pageSize);
        orderVo.setOrderList(orderPage.getRecords());
        orderVo.setTotal(orderPage.getTotal());
        return orderVo;
    }


}
