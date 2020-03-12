package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.ProductCategory;
import com.imooc.sell.repository.ProductCategoryRepository;
import com.imooc.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CategoryServiceImpl
 * @Description
 * @Author 47980
 * @Date 2020/3/12 22:36
 * @Version V_1.0
 **/
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private ProductCategoryRepository categoryRepository;

    @Override
    public ProductCategory findOne(Integer id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public List<ProductCategory> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return categoryRepository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return categoryRepository.save(productCategory);
    }
}
