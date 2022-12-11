//package com.euphoria.shop.rocketmq;
//
//import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
//import com.euphoria.shop.service.CouponPersonalService;
//import com.euphoria.shop.service.OrderService;
//import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
//import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
//import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
//import org.apache.rocketmq.common.message.MessageExt;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import java.nio.charset.StandardCharsets;
//import java.util.List;
//
///**
// * @author: Euphoria
// * @description: mq监听  //"1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h"
// * @date: 2022/8/22 8:36
// */
//@Component
//public class MQConsumeMsgListenerProcessor implements MessageListenerConcurrently {
//    public static final Logger LOGGER = LoggerFactory.getLogger(MQConsumeMsgListenerProcessor.class);
//    @Resource
//    private OrderService orderService;
//
//    @Autowired
//    private CouponPersonalService couponPersonalService;
//
//
//    /**
//     * 默认msg里只有一条消息，可以通过设置consumeMessageBatchMaxSize参数来批量接收消息
//     * 不要抛异常，如果没有return CONSUME_SUCCESS ，consumer会重新消费该消息，直到return CONSUME_SUCCESS
//     *
//     * @param msgList
//     * @param consumeConcurrentlyContext
//     * @return
//     */
//    @Override
//    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgList, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
//        if (CollectionUtils.isEmpty(msgList)) {
//            LOGGER.info("MQ接收消息为空，直接返回成功");
//            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
//        }
//        MessageExt messageExt = msgList.get(0);
//        try {
//            String topic = messageExt.getTopic();
//            String tags = messageExt.getTags();
//            String body = new String(messageExt.getBody(), StandardCharsets.UTF_8);
//            LOGGER.info("MQ消息topic={}, tags={}, 消息内容={}", topic, tags, body);
//            //订单业务
//            if (topic.equals("order")) {
//                if (tags.equals("generateOrder")) {
//                    //订单超时取消
//                    orderService.orderTimeOut(body);
//                }
//            }
//            //优惠券业务
//            if (topic.equals("coupon")) {
//                if(tags.equals("saveCoupon"))
//                //抢券
//                couponPersonalService.saveQuickCoupon(body);
//            }
//        } catch (Exception e) {
//            LOGGER.error("获取MQ消息内容异常{}", e);
//        }
//
//        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
//    }
//
//
//}
//
