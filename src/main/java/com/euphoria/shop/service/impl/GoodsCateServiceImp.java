package com.euphoria.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.euphoria.shop.service.GoodsCateService;
import com.euphoria.shop.entity.Goods;
import com.euphoria.shop.entity.GoodsCate;
import com.euphoria.shop.mapper.GoodsCateMapper;
import com.euphoria.shop.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author euphoria
 * @since 2022-08-03
 */
@Service
public class GoodsCateServiceImp extends ServiceImpl<GoodsCateMapper, GoodsCate> implements GoodsCateService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<GoodsCate> selectAllCate(int currentPage, int pageSize) {
        Page<GoodsCate> page = new Page<>(currentPage, pageSize);
        return baseMapper.selectPage(page, null).getRecords();
    }

    @Override
    public int addCate(GoodsCate goodsCate) {
        GoodsCate name = baseMapper.selectOne(new QueryWrapper<GoodsCate>().eq("name", goodsCate.getName()));
        if (name == null) {
            baseMapper.insert(goodsCate);
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteCate(Integer goodsCateId) {
        //  Long res = goodsMapper.selectCount(new QueryWrapper<Goods>().select("cid").eq("cid", goodsCateId));//  4ms
        List<Goods> res = goodsMapper.selectList(new QueryWrapper<Goods>().select("cid").eq("cid", goodsCateId)); //3ms
        if (res.isEmpty()) {
            baseMapper.deleteById(goodsCateId);
            return 1;
        }
        return 0;
    }
}
