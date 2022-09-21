package com.euphoria.shop.service;

import com.euphoria.shop.entity.Coupon;
import com.euphoria.shop.entity.CouponPersonal;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Euphoria
 * @since 2022-09-01
 */
public interface CouponPersonalService extends IService<CouponPersonal> {

    int saveQuickCoupon(String body);
    int saveCoupon(Long userId, Coupon coupon);

    List<Coupon> selectCoupon(Long userId);
}
