package com.euphoria.shop.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author Euphoria
 * @since 2022-09-01
 */
@Getter
@Setter
@TableName("coupon_personal")
@ApiModel(value = "CouponPersonal对象", description = "")
public class CouponPersonal implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("个人优惠券ID")
    @TableId(value = "coupon_personal_id", type = IdType.AUTO)
    private Long couponPersonalId;

    @ApiModelProperty("优惠券ID")
    private Long couponId;

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("个人优惠券状态  -1过期 2可用 3禁用")
    private Integer couponPerStatus;

    @ApiModelProperty("获取时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("过期时间")
    private LocalDateTime expirationTime;


}
