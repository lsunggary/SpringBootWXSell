package com.imooc.sell.repository;

import com.imooc.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    @Transactional
    public void createTest() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("科技图书");
        productCategory.setCategoryType(2);
        ProductCategory saveResult = repository.save(productCategory);
        Assert.assertNotNull(saveResult);
    }

    @Test
    public void findOneTest() {
        ProductCategory category = repository.findOne(1);
        Assert.assertEquals("category", category.getCategoryName());
    }

    @Test
    public void findAllTest() {
        List<ProductCategory> categoryList = repository.findAll();
        Assert.assertEquals(2, categoryList.size());
    }

    @Test
    @Transactional
    public void updateTest() {
        ProductCategory productCategory = repository.findOne(1);
        productCategory.setCategoryName("科技图书");
        productCategory.setCategoryType(2);
        ProductCategory saveResult = repository.save(productCategory);
        Assert.assertNotNull(saveResult);
        Assert.assertEquals("科技图书", saveResult.getCategoryName());
        Assert.assertEquals(2, saveResult.getCategoryType().intValue());
    }

    @Test
    @Transactional
    public void deleteTest() {
        repository.delete(2);
        ProductCategory productCategory = repository.findOne(2);
        Assert.assertNull(productCategory);
    }

    @Test
    public void findByType() {
        List<ProductCategory> productCategoryList = repository.findByCategoryTypeIn(Arrays.asList(3));
        assert productCategoryList != null;
        Assert.assertEquals(1, productCategoryList.size());
    }
}
