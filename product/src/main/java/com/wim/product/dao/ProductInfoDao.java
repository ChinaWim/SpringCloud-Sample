package com.wim.product.dao;

import com.wim.product.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInfoDao extends JpaRepository<ProductInfo,String> {

    List<ProductInfo> findAllByProductStatus(Integer productStatus);
}
