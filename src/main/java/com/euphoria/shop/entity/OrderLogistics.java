package com.euphoria.shop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

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
@TableName("order_logistics")
@ApiModel(value = "OrderLogistics对象", description = "订单物流表")
public class OrderLogistics implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("物流表ID")
    @TableId(value = "orderLogistics_id", type = IdType.AUTO)
    private Long orderLogisticsId;

    @ApiModelProperty("订单表ID")
    private Long orderId;

    @ApiModelProperty("物流单号")
    private Long expressNo;

    @ApiModelProperty("收货人姓名")
    private String consigneeName;

    @ApiModelProperty("联系电话")
    private String consigneeTelephone;

    @ApiModelProperty("收货人地址")
    private String consigneeAddress;


}
