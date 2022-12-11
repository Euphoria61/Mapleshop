package com.euphoria.shop.entity.vo;

import com.euphoria.shop.entity.Goods;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author: Euphoria
 * @description: TODO
 * @date: 2022/12/8 11:50
 */
@Getter
@Setter
public class GoodsToVo {
   private int currentPage;
   private int pageSize;
   private long total;
   private List<Goods> goodsList;

}
