package com.euphoria.shop.controller;

import com.euphoria.shop.entity.vo.OrderVo;
import com.euphoria.shop.service.OrderService;
import com.euphoria.shop.common.ResultInfo;
import com.euphoria.shop.common.annotation.LoginUser;
import com.euphoria.shop.entity.vo.OrderConfirmVo;
import com.euphoria.shop.entity.vo.OrderGenerateVo;
import com.euphoria.shop.entity.vo.OrderToConfirmVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
//import org.apache.rocketmq.client.exception.MQClientException;
//import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation("管理员显示订单")
    //@PreAuthorize("hasAuthority('sys:order:confirmOrder')")
    @GetMapping("/selectOrder")
    public ResultInfo<OrderVo> selectOrder(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                                           @RequestParam(value = "pageSize", defaultValue = "20") int pageSize) {
        return ResultInfo.success(orderService.selectOrder(currentPage,pageSize));
    }

    @ApiOperation("用户显示订单")
    //@PreAuthorize("hasAuthority('sys:order:confirmOrder')")
    @GetMapping("/selectOrderByUserId")
    public ResultInfo<OrderVo> selectOrderByUserId(@LoginUser Long userId,@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                                           @RequestParam(value = "pageSize", defaultValue = "20") int pageSize) {
        userId = 1556169985301184514L;
        return ResultInfo.success(orderService.selectOrderByUserId(userId,currentPage,pageSize));
    }


    @ApiOperation("显示订单确认")
    @PreAuthorize("hasAuthority('sys:order:confirmOrder')")
    @PostMapping("/confirmOrder")
    public ResultInfo<OrderConfirmVo> confirmOrder(OrderToConfirmVo order) {
        return ResultInfo.success(orderService.confirmOrder(order));
    }

    @ApiOperation("生成订单")
    //@PreAuthorize("hasAuthority('sys:order:generateOrder')")
    @PostMapping("/generateOrder")
    public ResultInfo<?> generateOrder(@LoginUser Long userId, @RequestBody OrderGenerateVo generateVo){
        userId = 1556169985301184514L;
        orderService.generateOrder(userId, generateVo);
        System.out.println(generateVo);
        return ResultInfo.success();
    }
}
