//package com.euphoria.shop.rocketmq;
//
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
//import org.apache.rocketmq.client.exception.MQClientException;
//import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @author: Euphoria
// * @description: mq消费者
// * @date: 2022/8/22 8:35
// */
//@Getter
//@Setter
//@ToString
//@Configuration
//@ConfigurationProperties(prefix = "rocketmq.consumer")
//public class MQConsumerConfigure {
//    public static final Logger LOGGER = LoggerFactory.getLogger(MQConsumerConfigure.class);
//
//    private String groupName;
//    private String namesrvAddr;
//    private String topics;
//    private Integer consumeThreadMin;
//    private Integer consumeThreadMax;
//    private Integer consumeMessageBatchMaxSize;
//
//
//    @Autowired
//    private MQConsumeMsgListenerProcessor consumeMsgListenerProcessor;
//
//    /**
//     * mq 消费者配置
//     *
//     * @return
//     * @throws MQClientException
//     */
//    @Bean
//    public DefaultMQPushConsumer defaultConsumer() throws MQClientException {
//        LOGGER.info("defaultConsumer 正在创建---------------------------------------");
//        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(groupName);
//        consumer.setNamesrvAddr(namesrvAddr);
//        // consumer.subscribe("*", "*");
//        consumer.setConsumeThreadMin(consumeThreadMin);
//        consumer.setConsumeThreadMax(consumeThreadMax);
//        consumer.setConsumeMessageBatchMaxSize(consumeMessageBatchMaxSize);
//        // 设置监听
//        consumer.registerMessageListener(consumeMsgListenerProcessor);
//
//        /**
//         * 设置consumer第一次启动是从队列头部开始还是队列尾部开始
//         * 如果不是第一次启动，那么按照上次消费的位置继续消费
//         */
//        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
//        /**
//         * 设置消费模型，集群还是广播，默认为集群
//         */
////        consumer.setMessageModel(MessageModel.CLUSTERING);
//
//        try {
//            //设置该消费者订阅的主题和tag，如果订阅该主题下的所有tag，则使用*,
//            String[] topicArr = topics.split(";");
//            for (String topic : topicArr) {
//                // String[] tagArr = topic.split("~");
//                consumer.subscribe(topic, "*");
//            }
//            consumer.start();
//            LOGGER.info("consumer 创建成功 groupName={}, topics={}, namesrvAddr={}", groupName, topics, namesrvAddr);
//        } catch (MQClientException e) {
//            LOGGER.error("consumer 创建失败!");
//        }
//        return consumer;
//    }
//}
//
