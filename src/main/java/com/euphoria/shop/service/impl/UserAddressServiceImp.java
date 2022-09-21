package com.euphoria.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.euphoria.shop.service.UserAddressService;
import com.euphoria.shop.entity.UserAddress;
import com.euphoria.shop.mapper.UserAddressMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 地址表 服务实现类
 * </p>
 *
 * @author euphoria
 * @since 2022-08-17
 */
@Service
public class UserAddressServiceImp extends ServiceImpl<UserAddressMapper, UserAddress> implements UserAddressService {

    @Override
    public List<UserAddress> listUserAddress(Long userId) {
        return baseMapper.selectList(new QueryWrapper<UserAddress>().eq("user_id", userId));
    }
}
