package com.gkw.cloud;

import com.gkw.cloud.MicroserviceSimpleConsumerMovieRibbonApplication;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

/**
 * @author 高孔威
 * @version 1.0
 * @Description:
 * @history:
 * @创建时间：2019/12/28 5:29 PM
 */
@Configuration
@ExcludeFromComponentScan
public class  TestConfiguration {
//
//    @Autowired
//    IClientConfig config;

    @Bean
    public IRule ribbonRule(){

        //负载均衡策略 RandomRule-随机请求 RoundRobinRule-轮询请求（默认）
        //此配置类不能和application放在同一个母包下，路径不能重叠（可以用排除扫描规避）
        //在application配置此策略对应的server
        return new RandomRule();
    }


}
