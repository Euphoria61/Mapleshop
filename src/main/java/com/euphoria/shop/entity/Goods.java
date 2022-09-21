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
 * @since 2022-08-03
 */
@Getter
@Setter
@ApiModel(value = "Goods对象", description = "商品信息")
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("商品ID")
    @TableId(value = "goods_id", type = IdType.AUTO)
    private Long goodsId;

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

    @ApiModelProperty("类型ID")
    private Long goodsCateId;

    @ApiModelProperty("是否上架")
    private Integer isShelf;

    @ApiModelProperty("详细信息")
    private String details;

    @ApiModelProperty("创建时间")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty("逻辑删除")
    @TableLogic
    private Integer deleted;

}
