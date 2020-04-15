package com.dafeng.management.goods.service.impl;

import com.dafeng.management.customer.entity.Customer;
import com.dafeng.management.goods.dao.GoodsMapper;
import com.dafeng.management.goods.entity.Goods;
import com.dafeng.management.goods.service.GoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * describe：
 * Created with IDEA
 *
 * @author ryan
 * Date:2020/4/14
 * Time:下午8:18
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public PageInfo<Goods> listCustomer(Goods customer, Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        List<Goods> goods = goodsMapper.list(customer);
        return new PageInfo<>(goods);
    }
}
