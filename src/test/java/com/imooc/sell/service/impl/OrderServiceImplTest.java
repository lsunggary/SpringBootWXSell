package com.imooc.sell.service.impl;

import com.imooc.sell.DTO.OrderDTO;
import com.imooc.sell.dataobject.OrderDetail;
import com.imooc.sell.enums.OrderStatusEnum;
import com.imooc.sell.service.OrderService;
import com.imooc.sell.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void create() {
        String orderId = KeyUtil.genUniqueKey();

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("10392847512");
        orderDetail.setProductName("从零开始学化妆");
        orderDetail.setProductPrice(new BigDecimal(666.66));
        orderDetail.setProductQuantity(2);
        orderDetail.setProductIcon("https://xxxxxxx");

        OrderDetail orderDetail2 = new OrderDetail();
        orderDetail2.setProductId("10392847513");
        orderDetail2.setProductName("教人分类");
        orderDetail2.setProductPrice(new BigDecimal(3.20));
        orderDetail2.setProductQuantity(1);
        orderDetail2.setProductIcon("https://xxxxxxx");

        List<OrderDetail> orderDetailList = new ArrayList<>();
        orderDetailList.add(orderDetail);
        orderDetailList.add(orderDetail2);

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("逸小帅");
        orderDTO.setBuyerAddress("上海市");
        orderDTO.setBuyerOpenid("wx1133ffdet342211");
        orderDTO.setBuyerPhone("17011837455");
        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void cancel() {
    }

    @Test
    public void finish() {
    }

    @Test
    public void paid() {
    }
}