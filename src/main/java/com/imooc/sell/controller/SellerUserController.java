package com.imooc.sell.controller;

import com.imooc.sell.constant.RedisConstant;
import com.imooc.sell.dataobject.SellerInfo;
import com.imooc.sell.service.SellerInfoService;
import com.imooc.sell.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

/**
 * @ClassName SellerUserController
 * @Description
 * @Author 47980
 * @Date 2020/3/16 22:47
 * @Version V_1.0
 **/
@Controller
@RequestMapping("/seller")
public class SellerUserController {

    @Autowired
    private SellerInfoService sellerInfoService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/login")
    public ModelAndView login(@RequestParam("username") String username,
                              @RequestParam("password") String password
                      ) {
        // 1.用username password 去和数据库做匹配
        SellerInfo sellerInfo = sellerInfoService.check(username, password);

        // 2.设置token至redis
        String token = UUID.randomUUID().toString();
        Integer expire= RedisConstant.EXPIRE;

        redisTemplate.opsForValue().set(
                String.format(RedisConstant.TOKEN_PREFIX, token),
                sellerInfo.getUsername(),
                expire);
        // 3.设置token至cookie
        return null;
    }

    @GetMapping("/logout")
    public void logout() {

    }
}
