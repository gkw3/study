package com.gkw.cloud;

import com.gkw.cloud.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 高孔威
 * @version 1.0
 * @Description:
 * @history:
 * @创建时间：2020/1/6 12:18 AM
 */
@FeignClient("microservice-provider-user")
public interface UserFeignClient {


    @GetMapping("/simple/{id}")
    User findById(@PathVariable(value = "id") Long id);

}
