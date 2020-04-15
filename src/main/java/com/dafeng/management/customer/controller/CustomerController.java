package com.dafeng.management.customer.controller;

import com.dafeng.management.common.ServerResponse;
import com.dafeng.management.customer.entity.Customer;
import com.dafeng.management.customer.service.CustomerService;
import com.github.pagehelper.PageInfo;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * describe：
 * Created with IDEA
 *
 * @author ryan
 * Date:2020/3/25
 * Time:下午7:29
 */

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * 获取客户信息列表
     * @param model
     * @return
     */
    @RequestMapping("list")
    public String list(Model model,Customer customer,@RequestParam(defaultValue = "1") Integer pageNum){
        PageInfo<Customer> customers = customerService.listCustomer(customer,pageNum);
        model.addAttribute("customers",customers);
        model.addAttribute("pageInfo",customer);
        model.addAttribute("pageNum",pageNum);
        model.addAttribute("province",customerService.getProvinces().toString());
        return "customer/list";
    }

    /**
     * 新增或者修改客户信息
     * @param customer
     * @return
     */
    @PostMapping("addOrModify")
    @ResponseBody
    public ServerResponse addOrModify(Customer customer){
        return customerService.addOrUpdate(customer);
    }

    /**
     * 校验公司名称是否重复
     * @param companyName
     * @param customerId
     * @return
     */
    @GetMapping("validateCompanyName")
    @ResponseBody
    public boolean validateCompanyName(String companyName,Integer customerId){
        return customerService.validateCompanyName(companyName,customerId);
    }

    /**
     * 校验联系人电话是否重复
     * @param phoneNum
     * @param customerId
     * @return
     */
    @GetMapping("validateLiaisonPhone")
    @ResponseBody
    public boolean validateLiaisonPhone(String phoneNum,Integer customerId){
        return customerService.validateLiaisonPhone(phoneNum,customerId);
    }

    /**
     * 根据省份 获取市
     * @param province
     *
     * @return
             */
    @GetMapping("citiesByProvince")
    @ResponseBody
    public String citiesByProvince(String province){
        return customerService.citiesByProvince(province).getData();
    }

    /**
     * 根据市 获取区域
     * @param city
     *
     * @return
     */
    @GetMapping("areasByCity")
    @ResponseBody
    public String areasByCity(String city){
        return customerService.areasByCity(city).getData();
    }

    /**
     * 根据区域 获取村庄
     * @param area
     *
     * @return
     */
    @GetMapping("villagesByArea")
    @ResponseBody
    public String villagesByArea(String area){
        return customerService.villagesByArea(area).getData();
    }

}
