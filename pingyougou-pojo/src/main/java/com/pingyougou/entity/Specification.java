package com.pingyougou.entity;

import com.pingyougou.pojo.TbSpecification;
import com.pingyougou.pojo.TbSpecificationOption;

import java.io.Serializable;
import java.util.List;

/**
 *
 * 规格组合实体类
 * Created by tanwen on 2018/11/12.
 */
public class Specification implements Serializable{

    private TbSpecification tbSpecification;

    List<TbSpecificationOption> optionList;

    public TbSpecification getTbSpecification() {
        return tbSpecification;
    }

    public void setTbSpecification(TbSpecification tbSpecification) {
        this.tbSpecification = tbSpecification;
    }

    public List<TbSpecificationOption> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<TbSpecificationOption> optionList) {
        this.optionList = optionList;
    }

    @Override
    public String toString() {
        return "Specification{" +
                "tbSpecification=" + tbSpecification +
                ", optionList=" + optionList +
                '}';
    }
}
