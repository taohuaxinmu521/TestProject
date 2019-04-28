package com.pingyougou.sellergoods;

import com.pingyougou.entity.PageResult;
import com.pingyougou.entity.Specification;
import com.pingyougou.pojo.TbSpecification;

import java.util.List;
import java.util.Map;

/**
 * Created by tanwen on 2018/11/12.
 */
public interface SpecificationService {

    /**
     * 规格列表分页
     * @param tbSpecification
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageResult findPage(TbSpecification tbSpecification, int pageNum, int pageSize);

    /**
     * 增加规格列表
     * @param specification
     */
    public void add(Specification specification);


    public Specification findOne(long id);

    public void update(Specification specification);

    public void delete(Long[] ids);

    List<Map> selectOptionList();
}
