package com.imooc.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @ClassName SellerInfo
 * @Description
 * @Author 47980
 * @Date 2020/3/16 22:22
 * @Version V_1.0
 **/
@Entity
@Data
public class SellerInfo {

    @Id
    private String sellerId;

    private String username;

    private String password;

    private String openid;
}
