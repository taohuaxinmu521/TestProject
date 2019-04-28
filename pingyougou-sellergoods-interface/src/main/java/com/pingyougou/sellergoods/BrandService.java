package com.pingyougou.sellergoods;

import com.pingyougou.entity.PageResult;
import com.pingyougou.pojo.TbBrand;

import java.util.List;
import java.util.Map;

/**
 * Created by tanwen on 2018/11/10.
 */
public interface BrandService {

    public List<TbBrand> getAll();

    public PageResult findPage(int pageNum,int pageSize);

    public void add(TbBrand tbBrand);

    public TbBrand findOne(long id);

    public void update(TbBrand tbBrand);

    public void delete(Long[] ids);

    /**
     * 品牌列表分页
     * @param tbBrand
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageResult findPage(TbBrand tbBrand,int pageNum,int pageSize);

    List<Map> selectOptionList();
}
