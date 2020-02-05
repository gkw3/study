package com.gkw.cloud.controller;

import com.gkw.cloud.entity.User;
import com.gkw.cloud.repository.UserRepository;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private Registration registration; // 服务注册

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


    @GetMapping("/eureka-instance")
    public String serviceUrl(){
        InstanceInfo instance= eurekaClient.getNextServerFromEureka("MICROSERVICE-PROVIDER-USER",false);
        return instance.getHomePageUrl();
    }

    @GetMapping("/instance-info")
    public ServiceInstance showInfo(){

        //2.0以后的方法
        ServiceInstance instance = serviceInstance();
        return instance;

    }

    @GetMapping("/user")
    public User postUser(@RequestBody User user){
        return user;

    }


    public ServiceInstance serviceInstance() {
        List<ServiceInstance> list = discoveryClient.getInstances(registration.getServiceId());
        if (list != null && list.size() > 0) {
            for(ServiceInstance itm : list){
                if(itm.getPort() == 7900)
                    return itm;
            }
        }
        return null;
    }


}
