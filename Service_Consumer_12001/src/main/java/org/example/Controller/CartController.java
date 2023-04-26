package org.example.Controller;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.example.Entity.CommonResult;
import org.example.Entity.User;
import org.example.Feign.UserFeignService;
import org.example.loadbalance.CustomLoadBalanceConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Cart")
@LoadBalancerClient(name = "provider-server",configuration = CustomLoadBalanceConfiguration.class)
public class CartController {

    @Autowired
    private UserFeignService userFeignService;

    @GetMapping("/addCart/{userId}")
    @RateLimiter(name = "ratelimiterA",fallbackMethod = "fallbackcc")
    public CommonResult<User> addCart(@PathVariable Integer userId){

        return userFeignService.getUserById(userId);
    }

    public CommonResult<User> fallback(Integer userId, Throwable e){

        e.printStackTrace();
        System.out.println("fallback");
        return new CommonResult<>(400,"service fallback",new User());
    }
}
