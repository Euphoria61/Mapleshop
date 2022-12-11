package com.euphoria.shop.entity.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author: Euphoria
 * @description: TODO
 * @date: 2022/12/9 23:59
 */
@Setter
@Getter
public class OrderToVo {
    @ApiModelProperty("订单ID")

    private Long orderId;

    @ApiModelProperty("商品数量")
    private Long goodsCount;


    @ApiModelProperty("商品数量")
    private Long orderNo;

    @ApiModelProperty("商品总价")
    private BigDecimal goodsAmountTotal;


    @ApiModelProperty("创建时间")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("商品ID")
    private Long goodsId;

    @ApiModelProperty("商品ID")
    private Long orderStatus;

    @ApiModelProperty("订单金额")
    private BigDecimal orderPrice;

    @ApiModelProperty("物品数量")
    private Long orderCount;

    @ApiModelProperty("商品价格")
    private BigDecimal goodsPrice;

    @ApiModelProperty("商品名称")
    private String goodsName;

    @ApiModelProperty("客户备注")
    private String remark;
}
