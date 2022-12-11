//package com.euphoria.shop.service.impl;
//
//import com.alibaba.fastjson.JSON;
//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.baomidou.mybatisplus.core.metadata.IPage;
//import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import com.euphoria.shop.entity.Goods;
//import com.euphoria.shop.service.CouponPersonalService;
//import com.euphoria.shop.service.CouponService;
//import com.euphoria.shop.entity.Coupon;
//import com.euphoria.shop.mapper.CouponMapper;
//import com.euphoria.shop.utils.RedisUtil;
//import org.apache.rocketmq.client.exception.MQClientException;
//import org.apache.rocketmq.client.producer.DefaultMQProducer;
//import org.apache.rocketmq.client.producer.SendCallback;
//import org.apache.rocketmq.client.producer.SendResult;
//import org.apache.rocketmq.common.message.Message;
//import org.apache.rocketmq.remoting.exception.RemotingException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.core.script.DefaultRedisScript;
//import org.springframework.scripting.support.ResourceScriptSource;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.time.LocalDateTime;
//import java.time.temporal.ChronoUnit;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.TimeUnit;
//
///**
// * <p>
// * 服务实现类
// * </p>
// *
// * @author Euphoria
// * @since 2022-08-31
// */
//@Service
//public class CouponServiceImp extends ServiceImpl<CouponMapper, Coupon> implements CouponService {
//
//    @Autowired
//    private RedisUtil redisUtil;
//    @Autowired
//    private RedisTemplate<String, Object> redisTemplate;
//    @Autowired
//    private DefaultMQProducer defaultMQProducer;
//
//    @Autowired
//    private CouponPersonalService couponPersonalService;
//
//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
//    @Override
//    public int giveCoupon(Coupon coupon) {
//        //优惠券类型为限时秒杀
//        if (coupon.getCouponGetChannel() == 1) {
//            //放入缓存 todo 异常处理
//            redisTemplate.opsForValue().set("coupon:" + coupon.getCouponId(), coupon.getCouponCount(), ChronoUnit.SECONDS.between(LocalDateTime.now(), coupon.getCouponStopTime()), TimeUnit.SECONDS);
//        }
//        //放入数据库
//        baseMapper.insert(coupon);
//        return 1;
//    }
//
//    @Override
//    public Long getQuickCoupon(Long userId, Coupon coupon) throws RemotingException, InterruptedException, MQClientException {
//        // lua完成
//        // 1.查验是否重复领取
//        // 2.查验库存，
//        // 3.扣减库存
//        // 4.记录领取
//        DefaultRedisScript<Long> redisScript =new  DefaultRedisScript<>();
//        redisScript.setResultType(Long.class);
//        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("lua/grabCoupon.lua")));
//        Long res =redisTemplate.execute(redisScript,Collections.singletonList(coupon.getCouponId().toString()),userId);
//        Map<String,Object> map =new HashMap<>();
//        map.put("userId",userId);
//        map.put("coupon",coupon);
//        //rocketMQ 发送异步--》MySQL记录
//        Message sendMsg = new Message("coupon", "saveCoupon", JSON.toJSONBytes(map));
//        defaultMQProducer.send(sendMsg, new SendCallback() {
//            //消息发送成功回调
//            @Override
//            public void onSuccess(SendResult sendResult) {
//                System.out.println("saveCoupon异步发送成功");
//            }
//            //消息异常回调
//            @Override
//            public void onException(Throwable e) {
//                e.printStackTrace();
//                //补偿机制，根据业务情况进行使用，看是否进行重试
//            }
//        });
//        return res;
//    }
//
//    @Override
//    public int getCoupon(Long userId, Coupon coupon) {
//        //加入会员即领券（无库存数量限制）
//        if(coupon.getCouponGetChannel() == 2){
//            couponPersonalService.saveCoupon(userId,coupon);
//        }
//        return 0;
//    }
//
//    @Override
//    public List<Coupon> selectCouponByShop(int currentPage,int pageSize,String shopId) {
//        Page<Coupon> goodsPage = new Page<>(currentPage, pageSize);
//        Page<Coupon> page = new LambdaQueryChainWrapper<>(baseMapper)
//                .eq(Coupon::getShopId,shopId)
//                .page(goodsPage);
//        return page.getRecords();
//    }
////    @Override
////    public List<Coupon> selectCouponByUserId(Long userId) {
////        LambdaQueryWrapper<Coupon> queryWrapper =new LambdaQueryWrapper();
////        queryWrapper.eq(Coupon::)
////        return baseMapper.selectList()
////    }
//}
