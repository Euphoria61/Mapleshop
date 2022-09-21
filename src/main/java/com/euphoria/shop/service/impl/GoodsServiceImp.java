package com.euphoria.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.euphoria.shop.service.GoodsService;
import com.euphoria.shop.entity.Goods;
import com.euphoria.shop.entity.GoodsCate;
import com.euphoria.shop.entity.vo.GoodsVo;
import com.euphoria.shop.mapper.GoodsMapper;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author euphoria
 * @since 2022-08-03
 */
@Service
public class GoodsServiceImp extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    //// TODO: 2022/9/15  mysql redis 数据一致性 

    @Override
    public List<Goods> selectShelfedGoods(int currentPage, int pageSize) {
        Page<Goods> goodsPage = new Page<>(
                currentPage, pageSize);
        Page<Goods> page = new LambdaQueryChainWrapper<>(baseMapper)
                .eq(Goods::getIsShelf, 1)
                .page(goodsPage);
        return page.getRecords();
    }

    @Override
    public List<Goods> selectByCate(int currentPage, int pageSize, String cate) {
        //建议联表查询还是用xml写吧，使用mybatis plus join 效率差不多
        IPage<Goods> goodsPage = baseMapper.selectJoinPage(new Page<>(currentPage, pageSize), Goods.class,
                new MPJLambdaWrapper<Goods>().selectAll(Goods.class)
                        .select(GoodsCate::getName)
                        .leftJoin(GoodsCate.class, GoodsCate::getGoodsCateId, Goods::getGoodsCateId)
                        .like(GoodsCate::getName, cate)
                        .eq(Goods::getIsShelf, 1)
        );
        return goodsPage.getRecords();
    }

    @Override
    public List<Goods> selectByWord(int currentPage, int pageSize, String word) {
        Page<Goods> goodsPage = new Page<>(
                currentPage, pageSize);
        return goodsMapper.selectByWord(goodsPage, word);
    }

    @Override
    public int changeStatus(Long goodsId) {
        LambdaUpdateWrapper<Goods> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(Goods::getGoodsId, goodsId).set(Goods::getIsShelf, 1 - getBaseMapper().selectById(goodsId).getIsShelf());
        if (baseMapper.update(null, lambdaUpdateWrapper) != 0) {
            return 1;
        }
        return 0;
    }

    @Override
    public int saveOrUpdateGoods(GoodsVo goodsVo) throws FileNotFoundException {
        String newFileName = "";
        String fileName = goodsVo.getPicture().getOriginalFilename();
        //选择文件
        if (fileName.length() > 0) {
            String path = ResourceUtils.getURL("classpath:").getPath() + "static/picture/goodsPicture";
            String realpath = path.replace('/', '\\').substring(1, path.length());
            //实现文件上传
            String fileType = fileName.substring(fileName.lastIndexOf('.'));
            //防止文件名重名
            newFileName = UUID.randomUUID() + fileType;
            File targetFile = new File(realpath, newFileName);
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            //上传
            try {
                goodsVo.getPicture().transferTo(targetFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Goods goods = new Goods();
            BeanUtils.copyProperties(goodsVo, goods);
            goods.setPicture(newFileName);
            System.out.println(goods);
            if (this.saveOrUpdate(goods)) {
                return 1;
            }
        }
        return 0;


    }

    @Override
    public Goods selectGoodsById(Long goodsId) {
        Goods goods = baseMapper.selectById(goodsId);
        if (goods != null) {
            return goods;
        }
        return null;
    }

    @Override
    public int reduceGoodsStore(Long goodsId, Long goodsCount) {
        this.update(new UpdateWrapper<Goods>().eq("goods_id", goodsId).setSql("store = store - " + goodsCount));
        return 0;
    }

    @Override
    public int incrGoodsStore(Long goodsId, Long goodsCount) {
        this.update(new UpdateWrapper<Goods>().eq("goods_id", goodsId).setSql("store = store + " + goodsCount));
        return 0;
    }

}
