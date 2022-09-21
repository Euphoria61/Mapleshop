package com.euphoria.shop.service;

import com.euphoria.shop.entity.Coupon;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Euphoria
 * @since 2022-08-31
 */
public interface CouponService extends IService<Coupon> {

    int giveCoupon(Coupon coupon);

    Long getQuickCoupon(Long userId, Coupon coupon) throws RemotingException, InterruptedException, MQClientException;

    int getCoupon(Long userId, Coupon coupon);

    List<Coupon> selectCouponByShop(int currentPage,int pageSize,String shopId);
}
