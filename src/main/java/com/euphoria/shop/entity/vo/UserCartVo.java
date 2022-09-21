package com.euphoria.shop.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author: Euphoria
 * @description: UserCart展示
 * @date: 2022/8/18 10:23
 */
@Getter
@Setter
@TableName("user_cart")
@ApiModel(value = "UserCart展示", description = "购物车")
public class UserCartVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("购物车ID")
    @TableId(value = "user_cart_id", type = IdType.AUTO)
    private Integer userCartId;

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("商品ID")
    private Long goodsId;

    @ApiModelProperty("商品数量")
    private Integer goodsCount;

    @ApiModelProperty("商品状态（已下架，已失效，已售罄）")
    private Integer status;

    @ApiModelProperty("商品名称")
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty("原价")
    private BigDecimal priceOld;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty("现价")
    private BigDecimal priceNew;

    @ApiModelProperty("库存")
    private Integer store;

    @ApiModelProperty("图片")
    private String picture;


}
