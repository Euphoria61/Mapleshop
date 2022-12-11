package com.euphoria.shop.controller;

import com.euphoria.shop.service.GoodsCateService;
import com.euphoria.shop.common.ResultInfo;
import com.euphoria.shop.entity.GoodsCate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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
@Api(tags = "商品类别")
@RequestMapping("/goodsCate")
public class GoodsCateController {
    @Autowired
    private GoodsCateService goodsCateService;

    @ApiOperation("显示全部商品类别")
    //@PreAuthorize("hasAuthority('sys:goodsCate:selectall')")
    @GetMapping("/selectAllCate")
    public ResultInfo<List<GoodsCate>> selectAll(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                                                 @RequestParam(value = "pageSize", defaultValue = "20") int pageSize) {
        return ResultInfo.success(goodsCateService.selectAllCate(currentPage, pageSize));
    }

    @ApiOperation("添加商品类别")
    //@PreAuthorize("hasAuthority('sys:goodsCate:add')")
    @PostMapping("/addCate")
    public ResultInfo<Integer> addCate(@RequestBody GoodsCate goodsCate) {

        return goodsCateService.addCate(goodsCate) == 0 ? ResultInfo.failed("商品类别已存在") : ResultInfo.success();
    }

    @ApiOperation("删除某个商品类别")
    //@PreAuthorize("hasAuthority('sys:goodsCate:delete')")
    @PostMapping("/deleteCate/{goodsCateId}")
    public ResultInfo deleteCate(@PathVariable("goodsCateId") int goodsCateId) {
        return goodsCateService.deleteCate(goodsCateId) == 0 ? ResultInfo.failed("仍有关联商品") : ResultInfo.success();
    }


}
