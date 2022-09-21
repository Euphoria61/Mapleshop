package com.euphoria.shop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author: Euphoria
 * @description: 鉴权菜单
 * @date: 2022/8/30 8:58
 */
@Getter
@Setter
@ApiModel(value = "Menu对象", description = "鉴权菜单")
@TableName("permission")
public class Menu implements Serializable {
    private static final long serialVersionUID = 1L;

    private int permissionId;

    private String permissionName;

    private String description;
}
