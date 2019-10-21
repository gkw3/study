package com.gkw.cloud.controller;

import com.gkw.cloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
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


    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id){
        return this.restTemplate.getForObject("http://127.0.0.1:7900/simple/"+id,User.class);
    }


}
