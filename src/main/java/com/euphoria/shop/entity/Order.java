package com.euphoria.shop.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author euphoria
 * @since 2022-08-17
 */
@Getter
@Setter
@ApiModel(value = "Order对象", description = "订单")
@TableName("`order`")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("订单ID")
    @TableId(value = "order_id", type = IdType.AUTO)
    private Long orderId;

    @ApiModelProperty("订单号")
    private Long orderNo;

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("商铺ID")
    private Long shopId;

    @ApiModelProperty("订单状态")
    private Integer orderStatus;

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

    @ApiModelProperty("订单物流ID")
    private Long orderLogisticsId;

    @ApiModelProperty("订单支付单号")
    private Long outTradeNo;

    @ApiModelProperty("创建时间")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("付款时间")
    private LocalDateTime payTime;

    @ApiModelProperty("发货时间")
    private LocalDateTime deliveryTime;

    @ApiModelProperty("订单结算时间")
    private LocalDateTime orderSettlementTime;

    @ApiModelProperty("货到付款，分期付款")
    private Integer orderSettlementStatus;


}
