package com.dafeng.management.customer.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Customer implements Serializable {
    private Integer id;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 地区
     */
    private String area;

    /**
     * 村
     */
    private String village;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 联系人
     */
    private String liaisonMan;

    /**
     * 联系人电话
     */
    private String liaisonPhone;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建日期
     */
    private Date createDate;

    private static final long serialVersionUID = 1L;


}