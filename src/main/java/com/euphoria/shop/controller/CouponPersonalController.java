//package com.euphoria.shop.controller;
//
//import com.baomidou.mybatisplus.core.mapper.BaseMapper;
//import com.euphoria.shop.common.ResultInfo;
//import com.euphoria.shop.common.annotation.LoginUser;
//import com.euphoria.shop.entity.Coupon;
//import com.euphoria.shop.service.CouponPersonalService;
//import com.euphoria.shop.service.CouponService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
///**
// * <p>
// *  前端控制器
// * </p>
// * @author Euphoria
// * @since 2022-09-01
// */
//@Api(value = "用户优惠券")
//@RestController
//@RequestMapping("/couponPersonal")
//public class CouponPersonalController {
//    @Autowired
//    private CouponPersonalService couponPersonalService;
//
//    @ApiOperation("显示个人优惠券")
//    @PostMapping("/selectCoupon")
//    public ResultInfo<List<Coupon>> selectCoupon(@LoginUser Long userId){
//        return ResultInfo.success(couponPersonalService.selectCoupon(userId));
//    }
//
//    @ApiOperation("使用优惠券")
//    @PostMapping("/useCoupon")
//    public ResultInfo<List<Coupon>> useCoupon(@LoginUser Long userId,Coupon coupon){
//        //// TODO: 2022/9/15 时间比较
//        return ResultInfo.success();
//    }
//
//}
