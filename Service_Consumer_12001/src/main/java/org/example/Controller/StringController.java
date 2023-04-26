package org.example.Controller;

import org.example.Feign.UserFeignService;
import org.example.loadbalance.CustomLoadBalanceConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/String")
@LoadBalancerClient(name = "provider-server",configuration = CustomLoadBalanceConfiguration.class)
public class StringController {
    @Autowired
    private UserFeignService userFeignService;

    @GetMapping("/hello")
    public String Hello(){

        return userFeignService.Hello();
    }


}
