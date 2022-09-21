package com.euphoria.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.euphoria.shop.entity.UserCart;
import com.euphoria.shop.entity.vo.UserCartVo;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author euphoria
 * @since 2022-08-12
 */
public interface UserCartService extends IService<UserCart> {

    int addCart(UserCart userCart);

    List<UserCartVo> selectCart(int currentPage, int pageSize, UserCart userCartId);

    int updateCount(UserCart userCart);

    int deleteByCartId(Long[] userCartIds);
}
