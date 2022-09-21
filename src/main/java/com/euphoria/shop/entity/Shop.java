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
 * @since 2022-08-18
 */
@Getter
@Setter
@ApiModel(value = "Shop对象", description = "")
public class Shop implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("店铺ID")
    @TableId(value = "shop_id", type = IdType.AUTO)
    private Long shopId;

    @ApiModelProperty("店铺名称")
    private String name;

    @ApiModelProperty("图片")
    private String picture;

    @ApiModelProperty("详细信息")
    private String details;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty("逻辑删除")
    @TableLogic
    private Integer deleted;


}
