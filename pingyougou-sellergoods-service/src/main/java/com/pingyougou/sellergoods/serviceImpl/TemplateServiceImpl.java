package com.pingyougou.sellergoods.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pingyougou.entity.PageResult;
import com.pingyougou.pojo.TbTypeTemplate;
import com.pingyougou.pojo.TbTypeTemplateExample;
import com.pingyougou.sellergoods.TemplateService;
import com.pingyougou.sellergoods.mapper.TbTypeTemplateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by tanwen on 2018/11/13.
 */
@Component
@Service(timeout = 3000)
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    TbTypeTemplateMapper typeTemplateMapper;

    @Override
    public PageResult findPage(TbTypeTemplate tbTypeTemplate, int pageNum, int pageSize) {

        PageHelper.startPage(pageNum,pageSize);

        TbTypeTemplateExample example = new TbTypeTemplateExample();
        TbTypeTemplateExample.Criteria criteria = example.createCriteria();

        Page<TbTypeTemplate> page = (Page<TbTypeTemplate>)typeTemplateMapper.selectByExample(example);
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public void add(TbTypeTemplate tbTypeTemplate) {
        typeTemplateMapper.insert(tbTypeTemplate);
    }

    @Override
    public TbTypeTemplate findOne(Long id) {
        return typeTemplateMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(TbTypeTemplate tbTypeTemplate) {
        typeTemplateMapper.updateByPrimaryKey(tbTypeTemplate);
    }

    @Override
    public void delete(Long[] ids) {
        for (long id:ids) {
            typeTemplateMapper.deleteByPrimaryKey(id);
        }
    }
}
