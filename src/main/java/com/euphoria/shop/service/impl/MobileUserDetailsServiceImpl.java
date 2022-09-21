package com.euphoria.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.euphoria.shop.entity.LoginUser;
import com.euphoria.shop.entity.User;
import com.euphoria.shop.mapper.MenuMapper;
import com.euphoria.shop.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Euphoria
 * @description: 手机号登录
 * @date: 2022/9/9 21:46
 */
@Service("MobileUserDetailsServiceImpl")
public class MobileUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        System.out.println("手机号登录");
        //根据手机号查询用户信息
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getTelephone, phone);
        User user = userMapper.selectOne(queryWrapper);
        //todo 注册 未查到则自动注册
//        if (Objects.isNull(user))
//            throw new ApiException(ResultCode.USER_PWD_ERROR);
        //查询权限
       //List<String> list = menuMapper.selectPermission(user.getUserId());
        List<String> list =new ArrayList<>();
        return new LoginUser(user,list);
    }
}
