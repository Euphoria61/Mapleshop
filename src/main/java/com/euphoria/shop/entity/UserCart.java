package com.euphoria.shop.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author euphoria
 * @since 2022-08-12
 */
@Getter
@Setter
@TableName("user_cart")
@ApiModel(value = "UserCart对象", description = "购物车")
public class UserCart implements Serializable {

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

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


}
