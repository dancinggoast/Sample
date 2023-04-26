package org.example.Controller;

import org.example.Entity.CommonResult;
import org.example.Entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
public class UserController {
    @GetMapping("/hello")
    public String Hello(){
        return "Hello World";
    }

    @GetMapping("/getUserById/{userId}")
    public CommonResult<User> getUserById(@PathVariable Integer userId){
        User u=new User(userId,"Thom york","123456");
        return new CommonResult<>(200,"success(11000)",u);
    }
}
