package com.euphoria.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.euphoria.shop.entity.Goods;
import com.euphoria.shop.entity.vo.GoodsVo;
import org.apache.ibatis.annotations.Param;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author euphoria
 * @since 2022-08-03
 */
public interface GoodsService extends IService<Goods> {
    //已上架商品
    List<Goods> selectShelfedGoods(@Param("currentPage") int currentPage, @Param("PageSize") int pageSize);

    //据商品类别查询已上架商品
    List<Goods> selectByCate(@Param("currentPage") int currentPage, @Param("PageSize") int pageSize, @Param("cate") String cate);

    //据关键词查询已上架商品
    List<Goods> selectByWord(@Param("currentPage") int currentPage, @Param("PageSize") int pageSize, @Param("word") String word);

    int changeStatus(Long goodsId);

    int saveOrUpdateGoods(GoodsVo goodsVo) throws FileNotFoundException;

    Goods selectGoodsById(Long goodsId);

    int reduceGoodsStore(Long goodsId, Long goodsCount);

    int incrGoodsStore(Long goodsId, Long goodsCount);

}
