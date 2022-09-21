package com.euphoria.shop.entity.vo;

import com.euphoria.shop.entity.Goods;
import com.euphoria.shop.entity.Shop;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author: Euphoria
 * @description: 接收前端订单生成
 * @date: 2022/8/18 10:23
 */
@Getter
@Setter
@ApiModel(value = "OrderToConfirm", description = "订单确认接收Vo")
public class OrderToConfirmVo implements Serializable {
    private static final long serialVersionUID = 1L;
    //查地址地址
    @ApiModelProperty("用户ID")
    private Long userId;
    //商品信息
    private Goods goods;
    //店铺信息
    private Shop shop;
    @ApiModelProperty("商品数量")
    private Long goodsCount;

    @ApiModelProperty("商品总价")
    private BigDecimal goodsAmountTotal;

    @ApiModelProperty("支付渠道")
    private String payChannel;

    @ApiModelProperty("订单实付金额")
    private BigDecimal orderAmountTotal;

    @ApiModelProperty("运费")
    private BigDecimal logisticsFee;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

}
