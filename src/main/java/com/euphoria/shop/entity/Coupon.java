package com.euphoria.shop.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 
 * </p>
 *
 * @author Euphoria
 * @since 2022-08-31
 */
@Getter
@Setter
@ApiModel(value = "Coupon对象", description = "优惠券实体类")
public class Coupon implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("优惠券ID")
    @TableId(value = "coupon_id", type = IdType.AUTO)
    private Long couponId;

    @ApiModelProperty("优惠券名称")
    private String couponName;

    @ApiModelProperty("优惠券类型   1满减 2立减 3折扣券 4优惠码")
    private String couponType;

    @ApiModelProperty("优惠券总数")
    private Integer couponCount;

    @ApiModelProperty("优惠券状态   -2 异常 -1失效   0创建未发行 1发行 2抢完")
    private Integer couponStatus;

    @ApiModelProperty("获取途径  1限时秒杀 2加入会员")
    private Integer couponGetChannel;

    @ApiModelProperty("限领张数")
    private Integer quota;

    @ApiModelProperty("店铺ID,发行者")
    private Long shopId;

    @ApiModelProperty("描述信息")
    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("优惠券发放截止时间")
    private LocalDateTime couponStopTime;

    @ApiModelProperty("有效时长")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime effectivePeriods;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("逻辑删除")
    @TableLogic
    private Integer deleted;


}
