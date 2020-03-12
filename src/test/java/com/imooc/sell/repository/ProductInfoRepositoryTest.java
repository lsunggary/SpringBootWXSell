package com.imooc.sell.repository;

import com.imooc.sell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/*
 商品详情repository类测试
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void saveTest(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("1");
        productInfo.setProductName("从零开始学JAVA");
        productInfo.setProductPrice(100.00f);
        productInfo.setProductStock(9999);
        productInfo.setProductIcon("https://cn.bing.com/images/search?view=detailV2&ccid=oRI168eo&id=EFD2AEDF57127429257C00E3CD8B0652FD59E4FB&thid=OIP.oRI168eoqODaqRPi3Z5HpgHaE7&mediaurl=http%3a%2f%2ffreegiftfromgod.com%2fblog%2fwp-content%2fuploads%2f2012%2f06%2fwpid-Photo-06062012-840-PM.jpg&exph=1362&expw=2048&q=%e5%9b%be%e7%89%87&simid=608032919013166069&selectedIndex=0");
        productInfo.setCategoryType(2);
        ProductInfo saveInfo = repository.save(productInfo);
        Assert.assertNotNull(saveInfo);
        Assert.assertEquals("从零开始学JAVA", saveInfo.getProductName());
    }
}
