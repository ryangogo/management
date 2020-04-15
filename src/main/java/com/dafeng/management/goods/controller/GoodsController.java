package com.dafeng.management.goods.controller;

import com.dafeng.management.customer.entity.Customer;
import com.dafeng.management.goods.entity.Goods;
import com.dafeng.management.goods.service.GoodsService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * describe：货物接口
 * Created with IDEA
 *
 * @author ryan
 * Date:2020/4/13
 * Time:下午7:34
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 获取客户信息列表
     * @param model
     * @return
     */
    @RequestMapping("list")
    public String list(Model model, Goods goods, @RequestParam(defaultValue = "1") Integer pageNum){
        PageInfo<Goods> goodsList = goodsService.listCustomer(goods, pageNum);
        model.addAttribute("pageInfo",goods);
        model.addAttribute("goodsList", goodsList);
        return "goods/list";
    }


}
