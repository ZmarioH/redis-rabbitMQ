package com.imooc.miaosha.controller;


import com.imooc.miaosha.domain.User;
import com.imooc.miaosha.redis.Key.UserKey;
import com.imooc.miaosha.redis.KeyPrefix;
import com.imooc.miaosha.redis.RedisService;
import com.imooc.miaosha.result.CodeMsg;
import com.imooc.miaosha.result.Result;
import com.imooc.miaosha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {


    @Autowired
    UserService userService;

    @Autowired
    RedisService redisService;


    //测试thymelaeaf
    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model){
        model.addAttribute("name","zhuhao");
        return "hello";
    }

    //测试数据库连接
    @RequestMapping("/getUser")
    @ResponseBody
    public User getById(){
        User user = userService.getById(1L);
        return user;
    }

    //测试redis
    @RequestMapping("/redis/get")
    @ResponseBody
    public Result<User> redisGet(){
        User user = redisService.get(UserKey.getById,""+1,User.class);
        System.out.println(user);
        return Result.success(user);
    }

    @RequestMapping("/redis/set")
    @ResponseBody
    public Result<Boolean> redisSet() {
        User user = new User();
        user.setId(1L);
        user.setName("zhuhao");
        redisService.set(UserKey.getById,""+1,user );
//        String str = redisService.get("key2", String.class);
        return Result.success(true);
    }

}
