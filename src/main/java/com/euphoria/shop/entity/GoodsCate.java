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
 * @since 2022-08-03
 */
@Getter
@Setter
@TableName("goods_cate")
@ApiModel(value = "GoodsType对象", description = "商品分类")
public class GoodsCate implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("商品分类ID")
    @TableId(value = "goods_cate_id", type = IdType.AUTO)
    private Integer goodsCateId;

    @ApiModelProperty("商品分类名称")
    private String name;


}
