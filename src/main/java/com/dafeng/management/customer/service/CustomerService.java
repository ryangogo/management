package com.dafeng.management.customer.service;


import com.dafeng.management.common.ServerResponse;
import com.dafeng.management.customer.entity.Customer;
import com.github.pagehelper.PageInfo;
import org.apache.poi.ss.formula.functions.T;
import org.json.JSONArray;

import java.util.List;


/**
 * describe：
 * Created with IDEA
 * author:ryan
 * Date:2019/8/10
 * Time:上午10:46
 */
public interface CustomerService {


    PageInfo<Customer> listCustomer(Customer customer,Integer pageNum);

    ServerResponse addOrUpdate(Customer customer);

    boolean validateCompanyName(String companyName, Integer customerId);

    boolean validateLiaisonPhone(String phoneNum, Integer customerId);

    JSONArray getProvinces();

    ServerResponse<String> citiesByProvince(String province);

    ServerResponse<String> areasByCity(String city);

    ServerResponse<String> villagesByArea(String area);
}
