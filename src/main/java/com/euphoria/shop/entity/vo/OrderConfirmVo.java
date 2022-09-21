package com.euphoria.shop.entity.vo;

import com.euphoria.shop.entity.Goods;
import com.euphoria.shop.entity.Shop;
import com.euphoria.shop.entity.UserAddress;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: Euphoria
 * @description: 确认订单数据显示
 * @date: 2022/8/18 10:38
 */
@Data
@ApiModel(value = "OrderConfirmVo", description = "订单确认回显Vo")
public class OrderConfirmVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("地址信息")
    private List<UserAddress> userAddress;

    @ApiModelProperty("商品信息")
    private Goods goods;

    @ApiModelProperty("店铺信息")
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
