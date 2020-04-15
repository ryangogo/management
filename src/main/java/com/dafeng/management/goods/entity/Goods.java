package com.dafeng.management.goods.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class Goods implements Serializable {

    private Integer id;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 包装单位
     */
    private String packageUnit;

    /**
     * 规格
     */
    private BigDecimal specifications;

    /**
     * 创建日期
     */
    private Date createDate;

    private static final long serialVersionUID = 1L;

}