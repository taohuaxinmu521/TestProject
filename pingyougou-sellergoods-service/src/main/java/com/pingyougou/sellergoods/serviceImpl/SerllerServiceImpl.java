package com.pingyougou.sellergoods.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pingyougou.common.ConUtils;
import com.pingyougou.entity.PageResult;
import com.pingyougou.pojo.TbSeller;
import com.pingyougou.pojo.TbSellerExample;
import com.pingyougou.sellergoods.SellerService;
import com.pingyougou.sellergoods.mapper.TbSellerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by tanwen on 2018/11/18.
 */
@Service(timeout = 3000)
@Component
public class SerllerServiceImpl implements SellerService {

    @Autowired
    TbSellerMapper sellerMapper;

    @Override
    public void addSeller(TbSeller seller) {
        seller.setStatus("0");
        seller.setCreateTime(new Date());
        sellerMapper.insert(seller);
    }

    /**
     * 查询为审核的上架信息
     * @param seller
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageResult findPage(TbSeller seller, int pageNum, int pageSize) {

        PageHelper.startPage(pageNum,pageSize);

        TbSellerExample example = new TbSellerExample();
        TbSellerExample.Criteria criteria = example.createCriteria();

        if (seller != null){
            criteria.andStatusEqualTo(seller.getStatus());
        }
        Page<TbSeller> page = (Page<TbSeller>)sellerMapper.selectByExample(example);
        return new PageResult(page.getTotal(),page.getResult());
    }

    public TbSeller findOne(String sellerId) {
        return sellerMapper.selectByPrimaryKey(sellerId);
    }

    @Override
    public void updateStatus(String sellerId, String status) {
        TbSeller seller = sellerMapper.selectByPrimaryKey(sellerId);
        seller.setStatus(status);
        sellerMapper.updateByPrimaryKey(seller);
    }


    public boolean login(String sellerId, String password) {
        TbSeller seller = sellerMapper.selectByPrimaryKey(sellerId);
        if (seller != null && seller.getPassword().equals(password) && seller.getStatus().equals(ConUtils.STATUS_REVIEWED)){
            return true;
        }
        return false;
    }
}
