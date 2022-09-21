package com.euphoria.shop.controller;

import com.euphoria.shop.common.ResultInfo;
import com.euphoria.shop.service.ShopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Result;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author euphoria
 * @since 2022-08-18
 */
@Api("店铺业务")
@RestController
@RequestMapping("/shop")
public class ShopController {

//    @Autowired
//    private ShopService shopService;
//
//    //todo 商家登录复写
//
//    @ApiOperation("显示店铺商品")
//    @GetMapping("/selectGoods")
//    public ResultInfo<?> selectGoods(Long shopId){
//        //// TODO: 2022/9/15 商品搜索分类
//        return ResultInfo.success(shopService.selectGoods(shopId));
//    }
//
//
//    @ApiOperation("添加店铺")
//    @ApiOperation("")
//    @ApiOperation("注销店铺")
}
