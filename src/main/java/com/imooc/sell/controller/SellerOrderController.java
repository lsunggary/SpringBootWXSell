package com.imooc.sell.controller;

import com.imooc.sell.DTO.OrderDTO;
import com.imooc.sell.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @ClassName SellerOrderController
 * @Description
 * @Author 47980
 * @Date 2020/3/16 21:22
 * @Version V_1.0
 **/
@Controller
@RequestMapping("/seller/order")
public class SellerOrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 订单列表
     * @param page 第几页，从1页开始
     * @param size 一页有多少条数据
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                             Map<String, Object> map
    ) {
        Pageable pageable = new PageRequest( page - 1, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(pageable);

        map.put("orderPage", orderDTOPage);

        return new ModelAndView("sell/list", map);
    }
}