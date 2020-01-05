package com.gkw.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import xyz.lxie.feign.springboot.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients

public class MovieFeignApplication {


	public static void main(String[] args) {
		SpringApplication.run(MovieFeignApplication.class, args);
	}

}
