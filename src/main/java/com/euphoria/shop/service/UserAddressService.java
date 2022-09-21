package com.euphoria.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.euphoria.shop.entity.UserAddress;

import java.util.List;

/**
 * <p>
 * 地址表 服务类
 * </p>
 *
 * @author euphoria
 * @since 2022-08-17
 */
public interface UserAddressService extends IService<UserAddress> {
    List<UserAddress> listUserAddress(Long userId);
}
