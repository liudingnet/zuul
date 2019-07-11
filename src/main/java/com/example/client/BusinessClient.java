package com.example.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="demo-business")
public interface BusinessClient {
    @RequestMapping("/business")
    String business();
}