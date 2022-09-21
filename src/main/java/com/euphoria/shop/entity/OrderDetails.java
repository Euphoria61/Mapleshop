package com.euphoria.shop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

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
@TableName("order_details")
@ApiModel(value = "OrderDetails对象", description = "订单明细")
public class OrderDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("订单明细表ID")
    @TableId(value = "order_details_id", type = IdType.AUTO)
    private Long orderDetailsId;

    @ApiModelProperty("订单ID")
    private Long orderId;

    @ApiModelProperty("商品ID")
    private Long goodsId;

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
