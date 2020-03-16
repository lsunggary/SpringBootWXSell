package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.SellerInfo;
import com.imooc.sell.service.SellerInfoService;
import com.imooc.sell.utils.KeyUtil;
import net.minidev.json.JSONUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoServiceImplTest {

    @Autowired
    private SellerInfoService sellerInfoService;

    @Test
    public void findOne() {
        SellerInfo user = sellerInfoService.findOne("admin");
        Assert.assertEquals("", user.getPassword());
        Assert.assertEquals("admin", user.getUsername());
    }

    @Test
    public void check() {
        SellerInfo user = sellerInfoService.check("admin", "admin");
        Assert.assertEquals("admin", user.getPassword());
    }

    @Test
    public void save() {
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setUsername("admin");
        sellerInfo.setPassword("admin");
        sellerInfo.setOpenid("wx1133ffdet342211");
        sellerInfo.setSellerId(KeyUtil.genUniqueKey());
        SellerInfo result = sellerInfoService.save(sellerInfo);
        System.out.println(result.toString());
        Assert.assertNotNull(result);
    }
}