package com.euphoria.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.euphoria.shop.service.UserCartService;
import com.euphoria.shop.entity.Goods;
import com.euphoria.shop.entity.UserCart;
import com.euphoria.shop.entity.vo.UserCartVo;
import com.euphoria.shop.mapper.UserCartMapper;
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
 * @since 2022-08-12
 */
@Service
public class UserCartServiceImp extends ServiceImpl<UserCartMapper, UserCart> implements UserCartService {

    @Override
    public int addCart(UserCart userCart) {


        return baseMapper.insert(userCart);
    }

    @Override
    public List<UserCartVo> selectCart(int currentPage, int pageSize, UserCart userCart) {

        IPage<UserCartVo> goodsPage = baseMapper.selectJoinPage(new Page<>(currentPage, pageSize), UserCartVo.class,
                new MPJLambdaWrapper<UserCartVo>().selectAll(UserCart.class)
                        .select(Goods::getName, Goods::getPicture, Goods::getPriceNew, Goods::getPriceOld, Goods::getStore)
                        .leftJoin(Goods.class, Goods::getGoodsId, UserCart::getGoodsId)
                        .eq(UserCart::getUserId, userCart.getUserId())
                        .orderByDesc(UserCart::getUserCartId)
        );
        return goodsPage.getRecords();
    }

    @Override
    public int updateCount(UserCart userCart) {
        int i = baseMapper.update(userCart, new UpdateWrapper<UserCart>()
                .eq("user_cart_id", userCart.getUserCartId())
                .set("goods_count", userCart.getGoodsCount()));
        return i;
    }

    @Override
    public int deleteByCartId(Long[] userCartIds) {
        return baseMapper.deleteBatchIds(Arrays.asList(userCartIds));
    }
}
