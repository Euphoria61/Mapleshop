package com.euphoria.shop.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.euphoria.shop.entity.Goods;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author euphoria
 * @since 2022-08-03
 */

public interface GoodsMapper extends MPJBaseMapper<Goods> {
    List<Goods> selectByWord(@Param("page") Page<?> page, @Param("word") String word);

    int incrGoodsStore(Long goodsId, Long goodsCount);
}
