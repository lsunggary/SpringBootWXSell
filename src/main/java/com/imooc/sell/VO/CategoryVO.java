package com.imooc.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @ClassName CategoryVO
 * @Description
 * @Author 47980
 * @Date 2020/3/12 23:31
 * @Version V_1.0
 **/
@Data
public class CategoryVO {

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductVO> productVO;
}
