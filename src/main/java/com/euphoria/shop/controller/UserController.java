package com.euphoria.shop.controller;

import com.euphoria.shop.common.ResultInfo;
import com.euphoria.shop.entity.User;
import com.euphoria.shop.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author euphoria
 * @since 2022-08-02
 */
@RestController
@Api(tags = "用户业务")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户注册")
    @PostMapping("/register")
    public ResultInfo<?> register(@RequestBody User user) {
        userService.Register(user);
        return ResultInfo.success();
    }

    @ApiOperation(value = "注册用户查重")
    @PostMapping("/checkUserName")
    public ResultInfo<?> checkUserName(String username) {
        return userService.checkUserName(username);
    }

    @ApiOperation(value = "用户登录实现")
    @PostMapping("/login")
    public ResultInfo<?> login(@RequestBody User user, HttpServletRequest request) {
        return userService.login(user, request);
    }

    @ApiOperation(value = "用户退出登录")
    @PostMapping("/logout")
    public ResultInfo<?> logout() {
        return userService.logout();
    }

    //修改信息

}