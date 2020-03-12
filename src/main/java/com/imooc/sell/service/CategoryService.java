package com.imooc.sell.service;

import com.imooc.sell.dataobject.ProductCategory;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName CategoryService
 * @Description interface
 * @Author 47980
 * @Date 2020/3/12 22:17
 * @Version V_1.0
 **/
public interface CategoryService {

    ProductCategory findOne(Integer id);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
