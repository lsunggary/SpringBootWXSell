package com.imooc.sell.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName WechatMorkController 模拟微信授权-支付
 * @Description
 * @Author 47980
 * @Date 2020/3/15 13:08
 * @Version V_1.0
 **/
@RestController(value = "/wx-api")
public class WechatMorkController {

    private final String  WX_OPENID = "wx1133ffdet342211";

    @PostMapping("/get-openid")
    public String getOpenid() {
        return WX_OPENID;
    }

    @PostMapping("/pay")
    public String toPay(@RequestParam("wxOpenid") String wxOpenid,
                        @RequestParam("orderId") String orderId,
                        @RequestParam("orderAmount") String orderAmount,
                        @RequestParam("orderName") String orderName
    ) {
        return "success";
    }
}

