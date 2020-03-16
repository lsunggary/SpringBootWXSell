package com.imooc.sell.VO;

import lombok.Data;

import javax.persistence.Entity;
import java.util.List;

/**
 * @ClassName ProductListVO
 * @Description
 * @Author 47980
 * @Date 2020/3/12 23:14
 * @Version V_1.0
 **/
@Data
public class ProductListVO {

    private Integer code;

    private String msg;

    private List<CategoryVO> data;
}
