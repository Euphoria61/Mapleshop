package com.euphoria.shop.controller;

import com.euphoria.shop.common.ResultInfo;
import com.euphoria.shop.entity.OrderLogistics;
import com.euphoria.shop.service.OrderLogisticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author euphoria
 * @since 2022-08-17
 */
@RestController
@Api(value = "物流业务")
@RequestMapping("/orderLogistics")
public class OrderLogisticsController {

    @Autowired
    private OrderLogisticsService orderLogisticsService;

    @ApiOperation(value = "订单发货")
    @PostMapping("/deliverGoods")
    public ResultInfo<?> deliverGoods(@RequestBody OrderLogistics orderLogistics) {
        return orderLogisticsService.deliverGoods(orderLogistics) == 0 ? ResultInfo.failed("发货失败") : ResultInfo.success();
    }
}
