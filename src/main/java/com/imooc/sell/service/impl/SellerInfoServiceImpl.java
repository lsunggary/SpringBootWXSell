package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.SellerInfo;
import com.imooc.sell.enums.ResultEnum;
import com.imooc.sell.exceptions.SellException;
import com.imooc.sell.repository.SellerInfoRepository;
import com.imooc.sell.service.SellerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName SellerInfoServiceImpl
 * @Description
 * @Author 47980
 * @Date 2020/3/16 22:27
 * @Version V_1.0
 **/
@Service
public class SellerInfoServiceImpl implements SellerInfoService {

    @Autowired
    private SellerInfoRepository sellerInfoRepository;

    @Override
    public SellerInfo findOne(String username) {
        SellerInfo user = sellerInfoRepository.getByUsernameIs(username);
        if (user == null) {
            throw new SellException(ResultEnum.USER_NOT_EXIST);
        }
        user.setPassword("");
        return user;
    }

    @Override
    public SellerInfo check(String username, String password) {
        SellerInfo user = sellerInfoRepository.getByUsernameIs(username);
        if (user == null || !user.getPassword().equals(password)) {
            throw new SellException(ResultEnum.USER_ERROR);
        }
        return user;
    }

    @Override
    public SellerInfo save(SellerInfo sellerInfo) {
        SellerInfo result = sellerInfoRepository.save(sellerInfo);
        if (result == null) {
            throw new SellException(ResultEnum.USER_NOT_EXIST);
        }
        return result;
    }
}
