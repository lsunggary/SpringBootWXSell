package com.imooc.sell.repository;

import com.imooc.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster("1","高学成",
                "17011865800","上海市浦东新区","wx13524632151423",
                100.00f,0,0);
        OrderMaster saveResult = repository.save(orderMaster);
        Assert.assertNotNull(saveResult);
        Assert.assertEquals("高学成", saveResult.getBuyerName());
    }
}
