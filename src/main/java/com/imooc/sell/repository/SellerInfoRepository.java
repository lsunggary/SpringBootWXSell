package com.imooc.sell.repository;

import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName SellerInfoRepository
 * @Description interface
 * @Author 47980
 * @Date 2020/3/16 22:24
 * @Version V_1.0
 **/
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {

    SellerInfo getByUsernameIs(String username);
}
