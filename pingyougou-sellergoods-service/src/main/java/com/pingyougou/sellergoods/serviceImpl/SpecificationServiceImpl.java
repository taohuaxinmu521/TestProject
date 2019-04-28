package com.pingyougou.sellergoods.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pingyougou.entity.PageResult;
import com.pingyougou.entity.Specification;
import com.pingyougou.pojo.TbSpecification;
import com.pingyougou.pojo.TbSpecificationExample;
import com.pingyougou.pojo.TbSpecificationOption;
import com.pingyougou.pojo.TbSpecificationOptionExample;
import com.pingyougou.sellergoods.SpecificationService;
import com.pingyougou.sellergoods.mapper.TbSpecificationMapper;
import com.pingyougou.sellergoods.mapper.TbSpecificationOptionMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by tanwen on 2018/11/12.
 */
@Component
@Service(timeout = 3000)
public class SpecificationServiceImpl implements SpecificationService {

    @Autowired
    TbSpecificationMapper tbSpecificationMapper;

    @Autowired
    TbSpecificationOptionMapper tbSpecificationOptionMapper;

    /**
     * 获取按条件搜索的分页信息
     * @param tbSpecification
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageResult findPage(TbSpecification tbSpecification, int pageNum, int pageSize) {

        PageHelper.startPage(pageNum,pageSize);

        TbSpecificationExample specificationExample = new TbSpecificationExample();
        TbSpecificationExample.Criteria criteria = specificationExample.createCriteria();

        if (tbSpecification != null){
            if (StringUtils.isNotEmpty(tbSpecification.getSpecName())){
                criteria.andSpecNameLike(tbSpecification.getSpecName());
            }
        }

        Page<TbSpecification> page = (Page<TbSpecification>)tbSpecificationMapper.selectByExample(specificationExample);

        return new PageResult(page.getTotal(),page.getResult());
    }


    /**
     * 增加产品规格
     * @param specification
     */
    @Override
    public void add(Specification specification) {
        if (specification != null){
            TbSpecification tbSpecification = specification.getTbSpecification();
            if (tbSpecification != null && specification.getOptionList().size() > 0){
                tbSpecificationMapper.insert(tbSpecification);
                for (TbSpecificationOption tb : specification.getOptionList()) {
                    tb.setSpecId(tbSpecification.getId());
                    tbSpecificationOptionMapper.insert(tb);
                }
            }
        }
    }


    public Specification findOne(long id) {
        //获取规格实体
        Specification specification = new Specification();
        specification.setTbSpecification(tbSpecificationMapper.selectByPrimaryKey(id));

        //获取规格选项列表
        TbSpecificationOptionExample example = new TbSpecificationOptionExample();
        TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
        criteria.andSpecIdEqualTo(id);
        specification.setOptionList(tbSpecificationOptionMapper.selectByExample(example));
        return specification;
    }

    @Transactional
    public void update(Specification specification) {
        TbSpecification tbSpecification = specification.getTbSpecification();
        tbSpecificationMapper.updateByPrimaryKey(tbSpecification);

        //删除原来规格对应的规格选项
        TbSpecificationOptionExample example = new TbSpecificationOptionExample();
        TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
        criteria.andSpecIdEqualTo(tbSpecification.getId());
        tbSpecificationOptionMapper.deleteByExample(example);

        List<TbSpecificationOption> list = specification.getOptionList();
        for (TbSpecificationOption option : list) {
            option.setSpecId(tbSpecification.getId());
            tbSpecificationOptionMapper.insert(option);
        }
    }

    @Transactional
    public void delete(Long[] ids) {
        for (long id:ids) {
            tbSpecificationMapper.deleteByPrimaryKey(id);
            //删除规格选项数据
            TbSpecificationOptionExample example = new TbSpecificationOptionExample();
            TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
            criteria.andSpecIdEqualTo(id);
            tbSpecificationOptionMapper.deleteByExample(example);
        }
    }

    public List<Map> selectOptionList() {
        return tbSpecificationMapper.selectOptionList();
    }
}
