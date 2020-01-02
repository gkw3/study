package com.gkw.cloud.controller;

import com.gkw.cloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 高孔威
 * @version 1.0
 * @Description:
 * @email:gaokw@ffcs.cn
 * @Company: 北京福富软件有限公司
 * @Copyright: Copyright (c) 2015 FFCS All Rights Reserved
 * @history:
 * @创建时间：2019/9/28 4:50 PM
 */ 

@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;


    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id){
        return this.restTemplate.getForObject("http://microservice-provider-user/simple/"+id,User.class);
    }

    @GetMapping("/test")
    public String test(){

        //        //打印访问信息，测试访问哪台
//        ServiceInstance serviceInstance= this.loadBalancerClient.choose("microservice-provider-user");
//        System.out.println("111："+serviceInstance.getHost()+":"+serviceInstance.getPort()+" "+
//                            serviceInstance.getServiceId());

        ServiceInstance serviceInstance2= this.loadBalancerClient.choose("microservice-provider-user2");
        System.out.println("222："+serviceInstance2.getHost()+":"+serviceInstance2.getPort()+" "+
                serviceInstance2.getServiceId());
        return "1";
    }


}
