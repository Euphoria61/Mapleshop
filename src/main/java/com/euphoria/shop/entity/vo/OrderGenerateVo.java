package com.euphoria.shop.entity.vo;

import com.euphoria.shop.entity.Goods;
import com.euphoria.shop.entity.Shop;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author: Euphoria
 * @description: 确认订单数据显示
 * @date: 2022/8/18 10:38
 */
@Data
@ApiModel(value = "OrderConfirmVo", description = "订单生成")
public class OrderGenerateVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("地址信息")
    private String orderAddress;

    @ApiModelProperty("真实姓名")

    private String realName;

    @ApiModelProperty("地址信息")
    private String telephone;

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


    @ApiModelProperty("客户备注")
    private String remark;
}
