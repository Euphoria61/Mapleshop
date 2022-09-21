package com.euphoria.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.euphoria.shop.common.ResultInfo;
import com.euphoria.shop.entity.User;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author euphoria
 * @since 2022-08-02
 */
public interface UserService extends IService<User> {


    ResultInfo logout();

    void Register(User user);

    ResultInfo login(User user, HttpServletRequest request);

    ResultInfo checkUserName(String username);
}
