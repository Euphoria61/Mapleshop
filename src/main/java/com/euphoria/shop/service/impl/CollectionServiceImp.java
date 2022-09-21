package com.euphoria.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.euphoria.shop.service.CollectionService;
import com.euphoria.shop.entity.Collections;
import com.euphoria.shop.entity.Goods;
import com.euphoria.shop.entity.vo.CollectionVo;
import com.euphoria.shop.mapper.CollectionMapper;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author euphoria
 * @since 2022-08-15
 */
@Service
public class CollectionServiceImp extends ServiceImpl<CollectionMapper, Collections> implements CollectionService {

    @Override
    public List<CollectionVo> selectAllCollection(int currentPage, int pageSize, Long userId) {
        IPage<CollectionVo> collectionVoIpage = baseMapper.selectJoinPage(new Page<>(currentPage, pageSize), CollectionVo.class,
                new MPJLambdaWrapper<>()
                        .selectAll(Collections.class)
                        .select(Goods::getName, Goods::getPicture, Goods::getPriceNew, Goods::getPriceOld)
                        .leftJoin(Collections.class, Collections::getGoodsId, Goods::getGoodsId)
                        .eq(Collections::getUserId, userId)
                        .orderByDesc(Collections::getCollectionId)
        );
        return collectionVoIpage.getRecords();
    }

    @Override
    public int deleteCollection(Long userId, Long[] col) {
        return baseMapper.deleteBatchIds(Arrays.asList(col));

    }

    @Override
    public List<CollectionVo> findCollection(int currentPage, int pageSize, Long userId, String word) {
        IPage<CollectionVo> collectionVoIpage = baseMapper.selectJoinPage(new Page<>(currentPage, pageSize), CollectionVo.class,
                new MPJLambdaWrapper<>()
                        .selectAll(Collections.class)
                        .select(Goods::getName, Goods::getPicture, Goods::getPriceNew, Goods::getPriceOld)
                        .leftJoin(Collections.class, Collections::getGoodsId, Goods::getGoodsId)
                        .eq(Collections::getUserId, userId)
                        .like(Goods::getName,word)
                        .orderByDesc(Collections::getCollectionId)
        );
        return collectionVoIpage.getRecords();
    }

    @Override
    public int addCollection(Long userId, Long goodsId) {
        Collections collections =new Collections();
        collections.setGoodsId(goodsId);
        collections.setUserId(userId);
        LambdaQueryWrapper<Collections> queryWrapper =new LambdaQueryWrapper<>();
        queryWrapper.eq(Collections::getUserId,userId).eq(Collections::getGoodsId,goodsId);
        if(baseMapper.selectOne(queryWrapper) == null)return 1;
        return 0;
    }
}
