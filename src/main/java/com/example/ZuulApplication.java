package com.example;

import com.example.client.BusinessClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@EnableFeignClients
@RestController
public class ZuulApplication {
    @Autowired
    BusinessClient businessClient;

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }

    @RequestMapping(value = "/available")
    public String available() {
        return "Spring in Action";
    }

    @RequestMapping(value = "/checked-out")
    public String checkedOut() {
        return "Spring Boot in Action";
    }

    @RequestMapping(value = "/feign")
    public String availableFeign() {
        return businessClient.business() + " Feign";
    }
}


