package com.imooc.sell.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @ClassName OrderForm
 * @Description
 * @Author 47980
 * @Date 2020/3/14 14:54
 * @Version V_1.0
 **/
@Data
public class OrderForm {

    /**
     * 买家姓名
     */
    @NotEmpty(message="姓名必填")
    private String name;

    /**
     * 买家手机号
     */
    @NotEmpty(message = "手机号必填")
    private String phone;

    /**
     * 买家地址
     */
    @NotEmpty(message = "地址必填")
    private String address;

    /**
     * 买家微信openid
     */
    @NotEmpty(message = "openid必填")
    private String openid;

    /**
     * 购物车必填
     */
    @NotEmpty(message = "物品信息必填")
    private String items;
}
