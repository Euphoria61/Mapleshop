package com.euphoria.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.euphoria.shop.entity.GoodsCate;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author euphoria
 * @since 2022-08-03
 */
public interface GoodsCateService extends IService<GoodsCate> {

    List<GoodsCate> selectAllCate(int currentPage, int pageSize);

    int addCate(GoodsCate goodsCate);

    int deleteCate(Integer goodsCateId);
}
