package com.dafeng.management.goods.dao;

import com.dafeng.management.goods.entity.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface GoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    Goods selectByPrimaryKey(Integer id);

    List<Goods> selectAll();

    int updateByPrimaryKey(Goods record);

    /**
     * 按照条件查询货物列表
     * @param customer
     * @return
     */
    List<Goods> list(Goods customer);
}