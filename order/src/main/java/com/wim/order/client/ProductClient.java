package com.wim.order.client;

import com.wim.order.dto.ProductInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "product")
public interface ProductClient {
    @GetMapping("/msg")
    String getProductMsg();


    /**
     * 注意Feign的GetMapping必须是没有参数或者参数写成@RequestParam，否则只能用PostMapping
     *
     * @param productStatus
     * @return
     */
    @GetMapping("/list")
    List<ProductInfo> getProductList(@RequestParam Integer productStatus);

}


