package com.imooc.sell.repository;

import com.imooc.sell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

        @Test
        public void saveTest() {
            OrderDetail orderDetail = new OrderDetail("1", "1", "1",
                    "从零开始学JAVA", new BigDecimal(100.00), 1, "https://cn.bing.com/images/search?view=detailV2&ccid=oRI168eo&id=EFD2AEDF57127429257C00E3CD8B0652FD59E4FB&thid=OIP.oRI168eoqODaqRPi3Z5HpgHaE7&mediaurl=http%3a%2f%2ffreegiftfromgod.com%2fblog%2fwp-content%2fuploads%2f2012%2f06%2fwpid-Photo-06062012-840-PM.jpg&exph=1362&expw=2048&q=%e5%9b%be%e7%89%87&simid=608032919013166069&selectedIndex=0");
            OrderDetail saveResult = repository.save(orderDetail);
            Assert.assertNotNull(saveResult);
        Assert.assertEquals("从零开始学JAVA", saveResult.getProductName());
    }
}
