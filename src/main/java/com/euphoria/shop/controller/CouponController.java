//package com.euphoria.shop.controller;
//
//import com.euphoria.shop.common.Exception.ResultCode;
//import com.euphoria.shop.common.ResultInfo;
//import com.euphoria.shop.common.annotation.Limiter;
//import com.euphoria.shop.common.annotation.LoginUser;
//import com.euphoria.shop.entity.Coupon;
//import com.euphoria.shop.service.CouponService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.apache.rocketmq.client.exception.MQClientException;
//import org.apache.rocketmq.remoting.exception.RemotingException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
///**
// * @author: Euphoria
// * @description: 优惠券服务
// * @date: 2022/8/31 9:12
// */
//
//@Api(value = "优惠券操作业务")
//@RestController
//@RequestMapping("/coupon")
//public class CouponController {
//    @Autowired
//    private CouponService couponService;
//
//    @ApiOperation("显示店铺优惠券")
//    //todo 权限
//    public ResultInfo<List<Coupon>> selectCouponByShop(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
//                                                       @RequestParam(value = "pageSize", defaultValue = "20") int pageSize,
//                                                       String shopId)
//    {
//        return ResultInfo.success(couponService.selectCouponByShop(currentPage, pageSize,shopId));
//    }
//
//
//    @ApiOperation("发放优惠券")
//    @PreAuthorize("hasAuthority('sys:coupon:give')")
//    @PostMapping("/giveCoupon")
//    public ResultInfo<?> giveCoupon(@RequestBody Coupon coupon) {
//        return couponService.giveCoupon(coupon) == 0 ? ResultInfo.failed(ResultCode.FAILED) : ResultInfo.success();
//    }
//
//
//    @ApiOperation("获取秒杀优惠券")
//    @Limiter(key = "limit", permitsPerSecond = 2, timeout = 500, timeunit = TimeUnit.MILLISECONDS, msg = "系统繁忙，请稍后再试！")
//    @PreAuthorize("hasAuthority('sys:coupon:grab')")
//    @PostMapping("/grabQuickCoupon")
//    public ResultInfo<?> grabQuickCoupon(@LoginUser Long userId,
//                                         @RequestBody Coupon coupon) throws RemotingException, InterruptedException, MQClientException {
//        Long res = couponService.getQuickCoupon(userId, coupon);
//        if (res == 0) return ResultInfo.success();
//        else if (res == 1) return ResultInfo.failed("优惠券已抢完！");
//        else if (res == 2) return ResultInfo.failed("不可重复领取");
//        else
//            return ResultInfo.failed("该优惠券已失效");
//
//    }
//
//    @ApiOperation("获取普通优惠券")
//    //todo 权限
//    @PostMapping("/grabCoupon")
//    public ResultInfo<?> grabCoupon(@LoginUser Long userId,
//                                    @RequestBody Coupon coupon) {
//        return couponService.getCoupon(userId, coupon) == 0 ? ResultInfo.success() : ResultInfo.failed();
//    }
//}
