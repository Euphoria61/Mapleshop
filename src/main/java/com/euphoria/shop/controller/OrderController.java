package com.euphoria.shop.controller;

import com.euphoria.shop.service.OrderService;
import com.euphoria.shop.common.ResultInfo;
import com.euphoria.shop.common.annotation.LoginUser;
import com.euphoria.shop.entity.vo.OrderConfirmVo;
import com.euphoria.shop.entity.vo.OrderGenerateVo;
import com.euphoria.shop.entity.vo.OrderToConfirmVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author euphoria
 * @since 2022-08-17
 */
@RestController
@Api(value = "订单业务")
@RequestMapping("/order")
public class OrderController {
    @Resource
    private OrderService orderService;

    @ApiOperation("显示订单确认")
    @PreAuthorize("hasAuthority('sys:order:confirmOrder')")
    @PostMapping("/confirmOrder")
    public ResultInfo<OrderConfirmVo> confirmOrder(OrderToConfirmVo order) {
        return ResultInfo.success(orderService.confirmOrder(order));

    }

    @ApiOperation("生成订单")
    @PreAuthorize("hasAuthority('sys:order:generateOrder')")
    @PostMapping("/generateOrder")
    public ResultInfo<?> generateOrder(@LoginUser Long userId, @RequestBody OrderGenerateVo generateVo) throws RemotingException, InterruptedException, MQClientException {
        orderService.generateOrder(userId, generateVo);
        return ResultInfo.success();
    }
}
