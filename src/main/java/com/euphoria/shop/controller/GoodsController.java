package com.euphoria.shop.controller;


import com.euphoria.shop.service.GoodsService;
import com.euphoria.shop.common.ResultInfo;
import com.euphoria.shop.entity.Goods;
import com.euphoria.shop.entity.vo.GoodsVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author euphoria
 * @since 2022-08-03
 */
@RestController
@Api(tags = "商品")
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @ApiOperation("显示首页已上架商品")
    @GetMapping("/selectGoods")
    @PreAuthorize("hasAuthority('sys:goods:selectShelfed')")
    public ResultInfo<List<Goods>> selectGoods(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                                               @RequestParam(value = "pageSize", defaultValue = "20") int pageSize) {
        return ResultInfo.success(goodsService.selectShelfedGoods(currentPage, pageSize));
    }
    @ApiOperation("显示类型搜索已上架商品")
    @PreAuthorize("hasAuthority('sys:goods:selectByCate')")
    @GetMapping("/selectByCate")
    public ResultInfo<List<Goods>> selectByCate(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                                                @RequestParam(value = "pageSize", defaultValue = "20") int pageSize,
                                                @RequestParam(value = "cate") String cate
    ) {
        return ResultInfo.success(goodsService.selectByCate(currentPage, pageSize, cate));
    }
    @ApiOperation("显示关键词搜索已上架商品")
    @PreAuthorize("hasAuthority('sys:goods:selectByWord')")
    @GetMapping("/selectByWord/{word}")
    public ResultInfo<List<Goods>> goodsByWord(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                                               @RequestParam(value = "pageSize", defaultValue = "20") int pageSize,
                                               @PathVariable String word) {
        return ResultInfo.success(goodsService.selectByWord(currentPage, pageSize, word));
    }
    @ApiOperation("上下架操作")
    @PreAuthorize("hasAuthority('sys:goods:changeStatus')")
    @PostMapping("/changeStatus/{goodsId}")
    public ResultInfo<?> changeStatus(@PathVariable Long goodsId) {
        return goodsService.changeStatus(goodsId) == 0 ? ResultInfo.failed("操作失败") : ResultInfo.success();
    }

    @ApiOperation("添加或修改商品")
    @PreAuthorize("hasAuthority('sys:goods:addGoods')")
    @PostMapping("/addGoods")
    public ResultInfo<?> saveOrUpdateGoods(GoodsVo goodsVo) throws FileNotFoundException {
        return goodsService.saveOrUpdateGoods(goodsVo) == 0 ? ResultInfo.failed("操作失败") : ResultInfo.success();
    }

    @ApiOperation("ID查询商品")
    @PreAuthorize("hasAuthority('sys:goods:selectGoodsById')")
    @PostMapping("/selectGoodsById")
    public ResultInfo<Goods> selectGoodsById(@RequestParam Long goodsId) {
        return goodsService.selectGoodsById(goodsId) == null ? ResultInfo.failed("查询失败") : ResultInfo.success();
    }

    @ApiOperation("删除商品")
    @PreAuthorize("hasAuthority('sys:goods:deleteGoodsByIds')")
    @PostMapping("/deleteGoodsByIds")
    public ResultInfo<Goods> deleteGoodsByIds(@RequestParam Long[] goodsIds) {
        return !goodsService.removeByIds(Arrays.asList(goodsIds)) ? ResultInfo.failed("刪除失败") : ResultInfo.success();
    }


}