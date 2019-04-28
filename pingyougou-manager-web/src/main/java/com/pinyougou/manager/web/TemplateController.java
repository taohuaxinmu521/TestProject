package com.pinyougou.manager.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pingyougou.common.ConUtils;
import com.pingyougou.entity.PageResult;
import com.pingyougou.entity.Result;
import com.pingyougou.entity.Specification;
import com.pingyougou.pojo.TbTypeTemplate;
import com.pingyougou.sellergoods.BrandService;
import com.pingyougou.sellergoods.TemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by tanwen on 2018/11/13.
 */
@Slf4j
@Controller
@RequestMapping("template")
public class TemplateController {

    @Reference
    TemplateService templateService;


    @RequestMapping("search")
    @ResponseBody
    public PageResult search(@RequestBody TbTypeTemplate tbTypeTemplate, int page, int size){
        log.info("---------------获取类型模板信息的分页列表------------------");
        PageResult pageResult = templateService.findPage(tbTypeTemplate,page,size);
        return pageResult;
    }

    @RequestMapping("add")
    @ResponseBody
    public Result add(@RequestBody TbTypeTemplate tbTypeTemplate){
        try {
            templateService.add(tbTypeTemplate);
            System.out.println(tbTypeTemplate);
            return  new Result(true, ConUtils.ADD_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return  new Result(false,ConUtils.ADD_FAIL);
        }
    }

    @RequestMapping("update")
    @ResponseBody
    public Result update(@RequestBody TbTypeTemplate tbTypeTemplate){
        try {
            templateService.update(tbTypeTemplate);
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
            templateService.delete(ids);
            return  new Result(true,ConUtils.DELETE_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return  new Result(false,ConUtils.DELETE_SUCCESS);
        }
    }

    @RequestMapping("findOne")
    @ResponseBody
    public TbTypeTemplate findOne(long id){
        return templateService.findOne(id);
    }
}
