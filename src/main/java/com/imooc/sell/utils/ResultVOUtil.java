package com.imooc.sell.utils;

import com.imooc.sell.VO.ResultVO;

/**
 * @ClassName resultVOUtil
 * @Description
 * @Author 47980
 * @Date 2020/3/14 15:04
 * @Version V_1.0
 **/
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(200);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
