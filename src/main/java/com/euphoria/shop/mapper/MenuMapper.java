package com.euphoria.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.euphoria.shop.entity.GoodsCate;
import com.euphoria.shop.entity.Menu;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author euphoria
 * @since 2022-08-03
 */
public interface MenuMapper extends BaseMapper<Menu> {
    List<String> selectPermission(Long userId);
}
