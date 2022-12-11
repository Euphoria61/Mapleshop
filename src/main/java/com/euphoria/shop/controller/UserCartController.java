package com.euphoria.shop.controller;

import com.euphoria.shop.service.UserCartService;
import com.euphoria.shop.common.ResultInfo;
import com.euphoria.shop.common.annotation.LoginUser;
import com.euphoria.shop.entity.UserCart;
import com.euphoria.shop.entity.vo.UserCartVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author euphoria
 * @since 2022-08-12
 */
@RestController
@Api(tags = "购物车")
@RequestMapping("/userCart")
public class UserCartController {
    @Resource
    private UserCartService userCartService;

    @ApiOperation(value = "显示购物车")
//    @PreAuthorize("hasAuthority('sys:cart:selectAll')")
    @GetMapping("/selectCart")
    public ResultInfo<List<UserCartVo>> selectCart(@LoginUser Long userId,
                                                   @RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                                                   @RequestParam(value = "pageSize", defaultValue = "20") int pageSize,
                                                   UserCart usercart) {
        usercart.setUserId(1556169985301184514L);
        return ResultInfo.success(userCartService.selectCart(currentPage, pageSize, usercart));
    }


    @ApiOperation(value = "添加购物车")
    //@PreAuthorize("hasAuthority('sys:cart:addCart')")
    @PostMapping("/addCart")
    public ResultInfo<Integer> addCart(@LoginUser Long userId, @RequestBody UserCart userCart) {
        System.out.println(userId);
        userCart.setUserId(1556169985301184514L);
        return userCartService.addCart(userCart) == 0 ? ResultInfo.failed("添加失败") : ResultInfo.success();
    }

    @ApiOperation(value = "更新cart里商品数量")
    @PreAuthorize("hasAuthority('sys:cart:updateCount')")
    @PostMapping("/updateCount")
    public ResultInfo<Integer> updateCount(@LoginUser Long userId, @RequestBody UserCart userCart) {
        userCart.setUserId(userId);
        return userCartService.updateCount(userCart) == 0 ? ResultInfo.failed("更新失败") : ResultInfo.success();
    }

    @ApiOperation(value = "删除购物车")
    //@PreAuthorize("hasAuthority('sys:cart:deleteCart')")
    @PostMapping("/deleteCart/{userCartIds}")
    public ResultInfo<Integer> deleteCart(@PathVariable Long[] userCartIds) {

        return userCartService.deleteByCartId(userCartIds) == 0
                ? ResultInfo.failed("删除失败") : ResultInfo.success();
    }


    //todo @ApiOperation("分类或关键字查询")
}


