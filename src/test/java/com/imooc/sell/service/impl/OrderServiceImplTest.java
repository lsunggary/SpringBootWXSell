package com.imooc.sell.service.impl;

import com.imooc.sell.DTO.OrderDTO;
import com.imooc.sell.dataobject.OrderDetail;
import com.imooc.sell.enums.OrderStatusEnum;
import com.imooc.sell.enums.PayStatusEnum;
import com.imooc.sell.service.OrderService;
import com.imooc.sell.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderService orderService;

    private static String ORDER_ID = "1584118427820";

    private static String OPEN_ID = "wx1133ffdet342211";

    @Test
    @Transactional
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
        OrderDTO one = orderService.findOne(ORDER_ID);
        log.info("【查询单个订单】 result={}",one);
        Assert.assertNotNull(one);
        Assert.assertEquals(ORDER_ID,one.getOrderId());
    }

    @Test
    public void findAll() {
        PageRequest request = new PageRequest(0,2);
        Page<OrderDTO> orderDTOPage = orderService.findList(OPEN_ID, request);
        log.info("【查询订单列表】 result={}",orderDTOPage.getTotalElements());
        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());
    }

    @Test
    @Transactional
    public void cancel() {
        OrderDTO one = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.cancel(one);
        log.info("【取消订单】 result={}",result);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(),result.getOrderStatus());
    }

    @Test
    @Transactional
    public void finish() {
        OrderDTO one = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.finish(one);
        log.info("【完结订单】 result={}",result);
        Assert.assertEquals(OrderStatusEnum.ACCEPT.getCode(),result.getOrderStatus());
    }

    @Test
    @Transactional
    public void paid() {
        OrderDTO one = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.paid(one);
        log.info("【完结订单】 result={}",result);
        Assert.assertEquals(PayStatusEnum.PAID.getCode(),result.getPayStatus());
    }

    @Test
    public void findList() {
        PageRequest request = new PageRequest(0,2);
        Page<OrderDTO> orderDTOPage = orderService.findList(request);
        log.info("【查询订单列表】 result={}",orderDTOPage.getTotalElements());
        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());
    }

}