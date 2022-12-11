package com.euphoria.shop.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.euphoria.shop.entity.Collections;
import com.euphoria.shop.service.CollectionService;
import com.euphoria.shop.common.ResultInfo;
import com.euphoria.shop.common.annotation.LoginUser;
import com.euphoria.shop.entity.vo.CollectionVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author euphoria
 * @since 2022-08-15
 */
@RestController
@Api(value = "收藏")
@RequestMapping("/collection")
public class CollectionController {
    @Resource
    private CollectionService collectionService;


    @ApiOperation("显示全部收藏")
    //@PreAuthorize("hasAuthority('sys:collection:selectAll')")
    @GetMapping("/selectAllCollection")
    public ResultInfo<List<CollectionVo>> selectAllCollection(@LoginUser Long userId,
                                                               @RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                                                              @RequestParam(value = "pageSize", defaultValue = "20") int pageSize
    ) {

        userId =1556169985301184514L;
        return ResultInfo.success(collectionService.selectAllCollection(currentPage, pageSize, userId));
    }





    @ApiOperation("添加收藏")
    //@PreAuthorize("hasAuthority('sys:collection:selectAll')")
    @PostMapping("/addAllCollection/{goodsId}")
    public ResultInfo<?> selectAllCollection(@LoginUser Long userId,@PathVariable Long goodsId
    ) {
        userId =1556169985301184514L;
        return collectionService.addCollection(userId, goodsId) == 0 ? ResultInfo.success():ResultInfo.failed("已收藏该商品！");
    }


    @ApiOperation("删除商品收藏")
    @PreAuthorize("hasAuthority('sys:collection:delete')")
    @GetMapping("/deleteCollection")
    public ResultInfo<List<CollectionVo>> deleteCollection(@LoginUser Long userId, Long[] colId
    ) {
        return collectionService.deleteCollection(userId, colId) == 0 ? ResultInfo.failed("删除失败") : ResultInfo.success();
    }

    @ApiOperation("关键字查询")
    //todo 权限
    //@PreAuthorize("hasAuthority('sys:collection:find')")
    @GetMapping("/findCollection")
    public ResultInfo<List<CollectionVo>> findCollection(@LoginUser Long userId,
                                                         @RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                                                         @RequestParam(value = "pageSize", defaultValue = "20") int pageSize,
                                                         @RequestParam(value = "word") String word
    ) {
        return ResultInfo.success(collectionService.findCollection(currentPage, pageSize, userId,word));    }

}
