package com.pingyougou.sellergoods;

import com.pingyougou.entity.PageResult;
import com.pingyougou.pojo.TbSeller;

/**
 * Created by tanwen on 2018/11/18.
 */
public interface SellerService {

    void addSeller(TbSeller seller);

    PageResult findPage(TbSeller seller,int pageNum, int pageSize);

    TbSeller findOne(String sellerId);

    void updateStatus(String sellerId,String status);

    boolean login(String sellerId,String password);
}
