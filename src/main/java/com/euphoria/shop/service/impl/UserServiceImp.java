package com.euphoria.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.euphoria.shop.service.UserService;
import com.euphoria.shop.common.Exception.ApiException;
import com.euphoria.shop.common.Exception.ResultCode;
import com.euphoria.shop.common.ResultInfo;
import com.euphoria.shop.entity.LoginUser;
import com.euphoria.shop.entity.User;
import com.euphoria.shop.mapper.UserMapper;

import com.euphoria.shop.utils.JwtUtil;
import com.euphoria.shop.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author euphoria
 * @since 2022-08-02
 */
@Service
public class UserServiceImp extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RedisUtil redisUtil;


    @Override
    public void Register(User user) {
        String newPwd = passwordEncoder.encode(user.getUserPwd());
        user.setUserPwd(newPwd);
        System.out.println(baseMapper.insert(user));
    }


    @Override
    public ResultInfo<?> login(
            User user,
//            String userName,String password,
            HttpServletRequest request) {
            //authenticate进行用户认证
            //密码登录 //todo 第三方登录 邮箱登录、扫码登录
             UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getUserPwd());
             Authentication authenticate = authenticationManager.authenticate(authenticationToken);
            //todo 第三方短信 --》接受code
//            MobileCodeLoginToken authenticationToken = new MobileCodeLoginToken(userName,password);
//            Authentication authenticate = authenticationManager.authenticate(authenticationToken);

            //如果认证未通过
            if (Objects.isNull(authenticate)) {
            throw new ApiException(ResultCode.VALIDATE_FAILED);
            }
            //认证通过生成jwt
            System.out.println("llll"+authenticate.getPrincipal());
                    LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
                    String userid = loginUser.getUser().getUserId().toString();
                    String jwt = JwtUtil.createToken(Long.valueOf(userid));
                    Map<String, String> map = new HashMap<>();
                    map.put("token", jwt);
                    //重复登录 --> 获取cookie
                    if(request.getHeader("token") !=null)return ResultInfo.failed("不可重复登录!");
                    redisUtil.set("userLogin:" + userid, loginUser, 30 * 60 * 24);
            return ResultInfo.success(map);
    }

    @Override
    public ResultInfo<?> checkUserName(String username) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName, username);
        if (Objects.isNull(baseMapper.selectOne(queryWrapper))) {
            return ResultInfo.failed(ResultCode.USER_EXIST);
        }
        return ResultInfo.success();
    }

    @Override
    public ResultInfo<?> logout() {
        //获取用户id
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Long userId = loginUser.getUser().getUserId();
        redisUtil.del("userLogin:" + userId);
        return ResultInfo.success("退出成功");
    }


}
