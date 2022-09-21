package com.euphoria.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.euphoria.shop.entity.Collections;
import com.euphoria.shop.entity.vo.CollectionVo;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author euphoria
 * @since 2022-08-15
 */
public interface CollectionService extends IService<Collections> {

    List<CollectionVo> selectAllCollection(int currentPage, int pageSize, Long userId);

    int deleteCollection(Long userId, Long[] col);

    List<CollectionVo> findCollection(int currentPage, int pageSize, Long userId, String word);

    int addCollection(Long userId, Long goodsId);

}
