package com.pingyougou.sellergoods.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pingyougou.entity.PageResult;
import com.pingyougou.pojo.TbItemCat;
import com.pingyougou.pojo.TbItemCatExample;
import com.pingyougou.sellergoods.ItemcatService;
import com.pingyougou.sellergoods.mapper.TbItemCatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by tanwen on 2018/11/18.
 */
@Service
@Component
public class ItemcatServiceImpl implements ItemcatService {

    @Autowired
    TbItemCatMapper itemCatMapper;

    public PageResult findPage(long parentId, int pageNum, int pageSize) {

        PageHelper.startPage(pageNum,pageSize);

        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        Page<TbItemCat> page = (Page<TbItemCat>)itemCatMapper.selectByExample(example);
        return new PageResult(page.getTotal(),page.getResult());
    }
}
