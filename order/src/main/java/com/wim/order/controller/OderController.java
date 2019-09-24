package com.wim.order.controller;

import com.wim.order.client.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OderController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductClient productClient;


    @GetMapping("/getProductMsg")
    public String getProductMsg() {
        //1.第一种方式 不能默认负载均衡，当调用的service是集群时
   /*     RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8080/msg", String.class);*/

        //2.第二种方式（利用loadBalancerClient）
       /* ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
        String url = String.format("http://%s:%s/msg", serviceInstance.getHost(), serviceInstance.getPort());
        return restTemplate.getForObject(url, String.class);
*/
        //3.第三种方式 创建restTemplate的时候添加loadBalancer注解
//       return restTemplate.getForObject("http://PRODUCT/msg", String.class);

        //4.第四种方式 使用Feign
        return productClient.getProductMsg();
    }
}
