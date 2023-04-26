package org.example.Controller;

import org.example.Entity.CommonResult;
import org.example.Entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class ConsumerServiceFallback {
    @RequestMapping(value = "/fallback",method = RequestMethod.GET)
    public CommonResult GetResult(){
        return new CommonResult(403,"ConsumerService went wrong!",new User());
    }
}
