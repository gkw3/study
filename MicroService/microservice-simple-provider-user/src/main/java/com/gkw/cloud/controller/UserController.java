package com.gkw.cloud.controller;

import com.gkw.cloud.entity.User;
import com.gkw.cloud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/simple/{id}")
    public User findById(@PathVariable  Long id) {
        //根据ID获取实体
        User user = new User();
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()){
            user=optional.get();
            return  user;
        }else{
            return  null;
        }

    }


}
