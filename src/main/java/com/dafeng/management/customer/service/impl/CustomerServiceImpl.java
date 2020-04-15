package com.dafeng.management.customer.service.impl;

import com.dafeng.management.common.ServerResponse;
import com.dafeng.management.customer.dao.CustomerMapper;

import com.dafeng.management.customer.entity.Customer;
import com.dafeng.management.customer.service.CustomerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * describe：
 * Created with IDEA
 * author:ryan
 * Date:2019/8/10
 * Time:上午10:46
 */
@Service
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private CustomerMapper customerMapper;


    @Override
    public PageInfo<Customer> listCustomer(Customer customer,Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        List<Customer> customers = customerMapper.list(customer);
        return new PageInfo<>(customers);
    }

    @Override
    public ServerResponse addOrUpdate(Customer customer) {
        try{
            Integer id = customer.getId();
            String companyName = customer.getCompanyName();
            //提交前还要后端再次验证公司名称和电话号码是否重复
            if(StringUtils.isNotBlank(companyName) && !validateCompanyName(companyName, id)){
                return ServerResponse.createByErrorMessage("客户创建失败:重复的公司名称");
            }
            String phoneNum = customer.getLiaisonPhone();
            if (!validateLiaisonPhone(phoneNum, id)){
                return ServerResponse.createByErrorMessage("客户创建失败:重复的电话号码");
            }
            if (id == null){
                customerMapper.insert(customer);
                return ServerResponse.createBySuccessMessage("新增客户成功");
            } else {
                customerMapper.updateByPrimaryKey(customer);
                return ServerResponse.createBySuccessMessage("客户信息修改成功");
            }
        } catch (Exception e){
            e.printStackTrace();
            return ServerResponse.createByErrorMessage("客户信息创建失败");
        }
    }

    @Override
    public boolean validateCompanyName(String companyName, Integer customerId) {
        return customerMapper.countCompanyName(companyName,customerId) == 0;
    }

    @Override
    public boolean validateLiaisonPhone(String phoneNum, Integer customerId) {
        return customerMapper.countLiaisonPhone(phoneNum,customerId) == 0;
    }

    @Override
    public JSONArray getProvinces() {
        List<String> provinces = customerMapper.getProvinces();
        JSONArray jsonArray = new JSONArray();
        for (String province : provinces){
            jsonArray.put(province);
        }
        return jsonArray;
    }

    @Override
    public ServerResponse<String> citiesByProvince(String province) {
        try {
            List<String> cities = customerMapper.citiesByProvince(province);
            JSONArray jsonArray = new JSONArray();
            for (String city : cities){
                jsonArray.put(city);
            }
            String json = jsonArray.toString();
            return ServerResponse.createBySuccess(json);
        } catch (Exception e){
            e.printStackTrace();
            return ServerResponse.createByError();
        }

    }

    @Override
    public ServerResponse<String> areasByCity(String city) {
        try {
            List<String> areas = customerMapper.areasByCity(city);
            JSONArray jsonArray = new JSONArray();
            for (String area : areas){
                jsonArray.put(area);
            }
            String json = jsonArray.toString();
            return ServerResponse.createBySuccess(json);
        } catch (Exception e){
            e.printStackTrace();
            return ServerResponse.createByError();
        }
    }

    @Override
    public ServerResponse<String> villagesByArea(String area) {
        try {
            List<String> villages = customerMapper.villagesByArea(area);
            JSONArray jsonArray = new JSONArray();
            for (String village : villages){
                jsonArray.put(village);
            }
            String json = jsonArray.toString();
            return ServerResponse.createBySuccess(json);
        } catch (Exception e){
            e.printStackTrace();
            return ServerResponse.createByError();
        }
    }



}
