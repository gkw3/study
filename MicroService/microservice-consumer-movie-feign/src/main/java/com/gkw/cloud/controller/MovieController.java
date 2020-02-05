package com.gkw.cloud.controller;

import com.gkw.cloud.UserFeignClient;
import com.gkw.cloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {

   @Autowired
   private UserFeignClient userFeignClient;


    @RequestMapping(value = "/movie/{id}",method = RequestMethod.GET)
    public User findById(@PathVariable(value = "id") Long id){

        return this.userFeignClient.findById(id) ;
    }


}
