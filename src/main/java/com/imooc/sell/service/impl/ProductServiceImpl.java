package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.repository.ProductInfoRepository;
import com.imooc.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ProductServiceImpl
 * @Description
 * @Author 47980
 * @Date 2020/3/12 22:44
 * @Version V_1.0
 **/
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public ProductInfo findOne(Integer id) {
        return productInfoRepository.findOne(id);
    }

    @Override
    public List<ProductInfo> findAll() {
        return productInfoRepository.findAll();
    }

    /**
     * 根据产品上下架状态查询
     * @param status
     * @return
     */
    @Override
    public List<ProductInfo> findByProductStatus(Integer status) {
        return productInfoRepository.findByProductStatusIs(status);
    }

    @Override
    public ProductInfo saveProductInfo(ProductInfo productInfo) {
        return productInfoRepository.save(productInfo);
    }
}
