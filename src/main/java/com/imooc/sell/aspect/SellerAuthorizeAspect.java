//package com.imooc.sell.aspect;
//
//import com.imooc.sell.exceptions.SellAuthorizeException;
//import com.imooc.sell.exceptions.SellException;
//import com.imooc.sell.utils.CookieUtil;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * @ClassName SellerAuthorizeAspect
// * @Description
// * @Author 47980
// * @Date 2020/3/16 23:14
// * @Version V_1.0
// **/
//@Aspect
//@Component
//public class SellerAuthorizeAspect {
//
//    @Autowired
//    private StringRedisTemplate redisTemplate;
//
//    /**
//     * execution 确定需要执行的方法
//     * ！ execution 跳过需要验证的方法
//     */
//    @Pointcut("execution(public * com.imooc.sell.controller.Seller*.*(..)) " +
//            "&& ! execution(public *com.imooc.sell.controller.SellerUserController.*(..))")
//    public void verify() {
//
//    }
//
//    @Before("verify()")
//    public void doVerify() {
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//        //查询cookies
//        Cookie cookie = CookieUtil.get(request, "token_");
//        if (cookie == null) {
//            throw new SellAuthorizeException();
//        }
//        // 查询reids
//        String token = redisTemplate.opsForValue().get("");
//        if (token == null) {
//            throw new SellAuthorizeException();
//        }
//    }
//}
