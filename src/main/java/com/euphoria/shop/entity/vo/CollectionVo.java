package com.euphoria.shop.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
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
 * @since 2022-08-15
 */
@Getter
@Setter
@ApiModel(value = "Collection对象", description = "收藏")
public class CollectionVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("收藏品ID")
    @TableId(value = "collection_id", type = IdType.AUTO)
    private Long collectionId;


    @ApiModelProperty("商品ID ")
    private Long goodsId;


    @ApiModelProperty("商品名称")
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty("原价")
    private BigDecimal priceOld;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty("现价")
    private BigDecimal priceNew;

    @ApiModelProperty("图片")
    private String picture;
}
