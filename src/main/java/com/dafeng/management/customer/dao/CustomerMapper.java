package com.dafeng.management.customer.dao;

import com.dafeng.management.customer.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * @author ryan
 */
@Mapper
public interface CustomerMapper {

    /**
     * 我拿这个工具来生成这些dao
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 然后阿里的插件提示我这些东西要注释
     * @param record
     * @return
     */
    int insert(Customer record);

    /**
     * 你说说这有啥好注释的
     * @param id
     * @return
     */
    Customer selectByPrimaryKey(Integer id);

    /**
     * 这方法干嘛的你看不懂吗
     * @return
     */
    List<Customer> selectAll();

    /**
     * 看不懂回家养猪吧
     * @param record
     * @return
     */
    int updateByPrimaryKey(Customer record);

    /**
     * 按照条件查询
     * @return
     */
    List<Customer> list(Customer customer);

    /**
     * 获取所有省份
     * @return
     */
    @Select("select distinct province from customer where province != '' and province is not null")
    List<String> getProvinces();

    /**
     * 获取所有城市
     * @return
     */
    @Select("select distinct city from customer where city != '' and city is not null and province = #{province}")
    List<String> citiesByProvince(@Param("province") String province);

    /**
     * 获取所有区域/乡镇
     * @return
     */
    @Select("select distinct area from customer where area != '' and area is not null and city = #{city}")
    List<String> areasByCity(@Param("city") String city);

    /**
     * 获取所有村
     * @return
     */
    @Select("select distinct village from customer where village != '' and village is not null and area = #{area}")
    List<String> villagesByArea(@Param("area") String area);

    /**
     * 校验公司名称是否已经被使用
     * @param companyName
     * @param customerId
     * @return
     */
    int countCompanyName(@Param("companyName") String companyName,@Param("customerId") Integer customerId);


    /**
     * 校验联系人电话是否已经被使用
     * @param phoneNum
     * @param customerId
     * @return
     */
    int countLiaisonPhone(@Param("phoneNum") String phoneNum,@Param("customerId") Integer customerId);


}