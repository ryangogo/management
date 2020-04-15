package com.dafeng.management.goods.service;

import com.dafeng.management.customer.entity.Customer;
import com.dafeng.management.goods.entity.Goods;
import com.github.pagehelper.PageInfo;

/**
 * describe：
 * Created with IDEA
 *
 * @author ryan
 * Date:2020/4/14
 * Time:下午8:18
 */

public interface GoodsService {

    PageInfo<Goods> listCustomer(Goods customer, Integer pageNum);

}
