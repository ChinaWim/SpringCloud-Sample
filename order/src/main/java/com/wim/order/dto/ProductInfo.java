package com.wim.order.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProductInfo {

    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    /** 状态 0正常1下架 */
    private Integer productStatus;

    private Integer categoryType;

    private Date createTime;

    private Date updateTime;





}
