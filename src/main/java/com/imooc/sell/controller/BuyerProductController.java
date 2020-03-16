package com.imooc.sell.controller;

import com.imooc.sell.VO.CategoryVO;
import com.imooc.sell.VO.ProductListVO;
import com.imooc.sell.VO.ProductVO;
import com.imooc.sell.VO.ResultVO;
import com.imooc.sell.dataobject.ProductCategory;
import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.enums.ProductStatusEnum;
import com.imooc.sell.service.CategoryService;
import com.imooc.sell.service.ProductService;
import com.imooc.sell.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName CustomerProductController
 * @Description
 * @Author 47980
 * @Date 2020/3/12 23:03
 * @Version V_1.0
 **/
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO getList() {
        List<ProductInfo> productInfoList = productService.findByProductStatus(ProductStatusEnum.UP.getCode());
        /**
         * lambda
         */
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());

        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        List<CategoryVO> categoryVOList = new ArrayList<>();
        // 数据拼装
        productCategoryList.forEach(productCategory -> {
            CategoryVO categoryVO = new CategoryVO();
            categoryVO.setCategoryName(productCategory.getCategoryName());
            categoryVO.setCategoryType(productCategory.getCategoryType());

            List<ProductVO> productVOList = new ArrayList<>();
            productInfoList.forEach(productInfo -> {
                ProductVO productVO = new ProductVO();
                if (productInfo.getCategoryType() == categoryVO.getCategoryType()) {
                    BeanUtils.copyProperties(productInfo, productVO);
                    productVOList.add(productVO);
                }
            });

            categoryVO.setProductVO(productVOList);
            categoryVOList.add(categoryVO);
        });

        return ResultVOUtil.success(categoryVOList);
    }
}
