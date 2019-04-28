package com.pingyougou.sellergoods;

import com.pingyougou.entity.PageResult;
import com.pingyougou.pojo.TbTypeTemplate;

/**
 * Created by tanwen on 2018/11/13.
 */
public interface TemplateService {

    public PageResult findPage(TbTypeTemplate tbTypeTemplate, int pageNum, int pageSize);

    public void add(TbTypeTemplate tbTypeTemplate);

    public TbTypeTemplate findOne(Long id);

    public void update(TbTypeTemplate tbTypeTemplate);

    public void delete(Long[] ids);
}
