package com.euphoria.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.euphoria.shop.common.Exception.ApiException;
import com.euphoria.shop.common.Exception.ResultCode;
import com.euphoria.shop.entity.LoginUser;
import com.euphoria.shop.entity.User;
import com.euphoria.shop.mapper.MenuMapper;
import com.euphoria.shop.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @package: com.euphoria.shop.Service.impl
 * @className: UserDetailsServiceImpl
 * @author: Euphoria
 * @description: 用户名密码登录
 * @date: 2022/8/6 10:39
 */
@Service("UserDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //查询用户信息
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName, username);

        User user = userMapper.selectOne(queryWrapper);
        if (Objects.isNull(user))
            throw new ApiException(ResultCode.USER_PWD_ERROR);
        //查询权限
        List<String> list = menuMapper.selectPermission(user.getUserId());
        return new LoginUser(user,list);
    }
}
