package com.gkw.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class MovieFeignApplication {

	/**
	 * Feign的坑：1、不支持GetMapping或者PostMapping
	 * 2、@PathVariable 必须声明其成员属性
	 */
	public static void main(String[] args) {
		SpringApplication.run(MovieFeignApplication.class, args);
	}

}
