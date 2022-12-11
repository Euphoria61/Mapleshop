//package com.euphoria.shop.service.impl;
//
//import com.alibaba.fastjson.JSON;
//import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import com.euphoria.shop.entity.Coupon;
//import com.euphoria.shop.entity.CouponPersonal;
//import com.euphoria.shop.mapper.CouponPersonalMapper;
//import com.euphoria.shop.service.CouponPersonalService;
//import com.github.yulichang.wrapper.MPJLambdaWrapper;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Map;
//
///**
// * <p>
// * 服务实现类
// * </p>
// *
// * @author Euphoria
// * @since 2022-09-01
// */
//@Service
//public class CouponPersonalServiceImp extends ServiceImpl<CouponPersonalMapper, CouponPersonal> implements CouponPersonalService {
//
//    @Override
//    public int saveQuickCoupon(String body) {
//        Map map = JSON.parseObject(body);
//        System.out.println("map" + map);
//        CouponPersonal couponPersonal = new CouponPersonal();
//        Coupon coupon = JSON.parseObject(JSON.toJSONString(map.get("coupon")), Coupon.class);
//        couponPersonal.setCouponId(coupon.getCouponId());
//        LocalDateTime effective = coupon.getEffectivePeriods();
//        LocalDateTime now = LocalDateTime.now();
//        couponPersonal.setExpirationTime(now.plusSeconds(effective.getSecond()).plusMinutes(effective.getMinute()).plusHours(effective.getHour()));
//        couponPersonal.setUserId((Long) map.get("userId"));
//        baseMapper.insert(couponPersonal);
//        return 0;
//    }
//
//    @Override
//    public int saveCoupon(Long userId, Coupon coupon) {
//        CouponPersonal couponPersonal = new CouponPersonal();
//        couponPersonal.setCouponId(coupon.getCouponId());
//        LocalDateTime effective = coupon.getEffectivePeriods();
//        LocalDateTime now = LocalDateTime.now();
//        couponPersonal.setExpirationTime(now.plusSeconds(effective.getSecond()).plusMinutes(effective.getMinute()).plusHours(effective.getHour()));
//        couponPersonal.setUserId(userId);
//        baseMapper.insert(couponPersonal);
//        return 0;
//    }
//
//    @Override
//    public List<Coupon> selectCoupon(Long userId) {
//        return baseMapper.selectJoinList(Coupon.class,
//                new MPJLambdaWrapper<Coupon>().selectAll(Coupon.class)
//                        .leftJoin(CouponPersonal.class, CouponPersonal::getCouponId, Coupon::getCouponId)
//                        .eq(CouponPersonal::getUserId, userId));
//
//    }
//}
