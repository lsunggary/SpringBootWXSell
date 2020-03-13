package com.imooc.sell.DTO;

import lombok.Data;

/**
 * @ClassName CartDTO
 * @Description
 * @Author 47980
 * @Date 2020/3/14 0:04
 * @Version V_1.0
 **/
@Data
public class CartDTO {

    private Integer productQuantity;

    private String productId;

    public CartDTO(Integer productQuantity, String productId) {
        this.productQuantity = productQuantity;
        this.productId = productId;
    }
}
