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
 * @since 2022-08-15
 */
@Getter
@Setter
@TableName(value = "collection")
@ApiModel(value = "Collection对象", description = "收藏")
public class Collections implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("收藏品ID")
    @TableId(value = "collection_id", type = IdType.AUTO)
    private Long collectionId;

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("商品ID ")
    private Long goodsId;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("状态")
    private int status;
}
