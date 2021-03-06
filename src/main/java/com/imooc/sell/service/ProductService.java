package com.imooc.sell.service;

import com.imooc.sell.dataobject.ProductInfo;

import java.util.List;

/**
 * @ClassName ProductService
 * @Description interface
 * @Author 47980
 * @Date 2020/3/12 22:38
 * @Version V_1.0
 **/
public interface ProductService {

    ProductInfo findOne(Integer id);

    List<ProductInfo> findAll();

    /**
     * 根据商品的上下架状态查询
     * @return
     */
    List<ProductInfo> findByProductStatus(Integer status);

    ProductInfo saveProductInfo(ProductInfo productInfo);
}
