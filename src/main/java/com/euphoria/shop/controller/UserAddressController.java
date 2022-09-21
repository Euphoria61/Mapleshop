package com.euphoria.shop.controller;

import com.euphoria.shop.common.ResultInfo;
import com.euphoria.shop.common.annotation.LoginUser;
import com.euphoria.shop.entity.UserAddress;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 地址表 前端控制器
 * </p>
 *
 * @author euphoria
 * @since 2022-08-17
 */
@Api("地址管理")
@RestController
@RequestMapping("/userAddress")
public class UserAddressController {
//    @ApiOperation("显示个人地址")
////    @ApiOperation("添加收货地址")
////    @PostMapping("/add")
////    public ResultInfo<?> addUserAddress(@LoginUser Long userId, @RequestBody UserAddress userAddress){
////        return ResultInfo.success()
////    }
//    @ApiOperation("更改收货地址")
//    @ApiOperation("删除收货地址")

}
