package com.pinyougou.manager.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pingyougou.common.ConUtils;
import com.pingyougou.entity.PageResult;
import com.pingyougou.entity.Result;
import com.pingyougou.entity.Specification;
import com.pingyougou.pojo.TbBrand;
import com.pingyougou.pojo.TbSpecification;
import com.pingyougou.sellergoods.SpecificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by tanwen on 2018/11/12.
 */
@Slf4j
@Controller
@RequestMapping("specification")
public class SpecificationController {

    @Reference
    SpecificationService specificationService;

    @RequestMapping("search")
    @ResponseBody
    public PageResult search(@RequestBody TbSpecification tbSpecification, int page, int size){
        log.info("---------------获取规格信息的分页列表------------------");
        PageResult pageResult = specificationService.findPage(tbSpecification,page,size);
        System.out.println(pageResult);
        return pageResult;
    }

    @RequestMapping("add")
    @ResponseBody
    public Result add(@RequestBody Specification specification){
        try {
            specificationService.add(specification);
            return  new Result(true, ConUtils.ADD_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return  new Result(false,ConUtils.ADD_FAIL);
        }
    }

    @RequestMapping("findOne")
    @ResponseBody
    public Specification findOne(long id){
        Specification specification = specificationService.findOne(id);
        return specification;
    }

    @RequestMapping("update")
    @ResponseBody
    public Result update(@RequestBody Specification specification){
        try {
            specificationService.update(specification);
            return  new Result(true,ConUtils.UPDATE_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return  new Result(false,ConUtils.UPDATE_FAIL);
        }
    }

    @RequestMapping("delete")
    @ResponseBody
    public Result delete(Long [] ids){
        try {
            specificationService.delete(ids);
            return  new Result(true,ConUtils.DELETE_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return  new Result(false,ConUtils.DELETE_FAIL);
        }
    }


    @RequestMapping("optionList")
    @ResponseBody
    public List<Map> optionList(){
        return specificationService.selectOptionList();
    }
}
