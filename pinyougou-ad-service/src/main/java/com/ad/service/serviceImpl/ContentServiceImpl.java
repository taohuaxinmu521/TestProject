package com.ad.service.serviceImpl;

import com.ad.content.service.ContentService;
import com.ad.service.mapper.TbContentMapper;
import com.alibaba.dubbo.config.annotation.Service;
import com.pingyougou.pojo.TbContent;
import com.pingyougou.pojo.TbContentExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by tanwen on 2018/12/1.
 */
@Service(timeout = 5000)
@Component
public class ContentServiceImpl implements ContentService {

    @Autowired
    TbContentMapper contentMapper;

    @Override
    public List<TbContent> findAll() {
        return contentMapper.selectByExample(null);
    }

    @Override
    public List<TbContent> findByCategoryId(long categoryId) {
        TbContentExample example = new TbContentExample();
        TbContentExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(categoryId);
        criteria.andStatusEqualTo("1");
        example.setOrderByClause("sort_order");
        return contentMapper.selectByExample(example);
    }
}
