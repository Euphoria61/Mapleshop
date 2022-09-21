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
import java.time.LocalDateTime;

/**
 * <p>
 * 地址表
 * </p>
 *
 * @author euphoria
 * @since 2022-08-17
 */
@Getter
@Setter
@TableName("user_address")
@ApiModel(value = "UserAddress对象", description = "地址表")
public class UserAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("地址表ID")
    @TableId(value = "address_id", type = IdType.AUTO)
    private Long addressId;

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("真实姓名")
    private String realname;

    @ApiModelProperty("联系方式")
    private Integer telphone;

    @ApiModelProperty("国家")
    private String country;

    @ApiModelProperty("身份")
    private String province;

    @ApiModelProperty("城市")
    private String city;

    @ApiModelProperty("地区")
    private String area;

    @ApiModelProperty("街道")
    private String street;

    @ApiModelProperty("邮政编码")
    private Integer zip;

    @ApiModelProperty("是否设为默认地址")
    private Integer isDefaultAddress;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

}
