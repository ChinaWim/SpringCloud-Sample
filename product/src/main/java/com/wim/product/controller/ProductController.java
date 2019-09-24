package com.wim.product.controller;

import com.wim.product.dao.ProductInfoDao;
import com.wim.product.entity.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ProductController {

    @Autowired
    private ProductInfoDao productInfoDao;

    @GetMapping("/list")
    public List<ProductInfo> list(@RequestParam Integer productStatus) {
        return productInfoDao.findAllByProductStatus(productStatus);
    }
    @GetMapping("/msg")
    public String msg() {
        return "Hello SpringCloud RestTemplate";
    }


}
