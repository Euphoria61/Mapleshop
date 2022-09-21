package com.euphoria.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.euphoria.shop.service.OrderDetailsService;
import com.euphoria.shop.entity.OrderDetails;
import com.euphoria.shop.mapper.OrderDetailsMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author euphoria
 * @since 2022-08-17
 */
@Service
public class OrderDetailsServiceImp extends ServiceImpl<OrderDetailsMapper, OrderDetails> implements OrderDetailsService {

}
