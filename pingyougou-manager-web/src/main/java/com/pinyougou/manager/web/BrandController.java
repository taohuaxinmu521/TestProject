package com.pinyougou.manager.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pingyougou.common.ConUtils;
import com.pingyougou.entity.PageResult;
import com.pingyougou.entity.Result;
import com.pingyougou.pojo.TbBrand;
import com.pingyougou.sellergoods.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by tanwen on 2018/11/10.
 */
@Slf4j
@Controller
@RequestMapping("brand")
public class BrandController {

    @Reference
    BrandService brandService;

    /**
     * 获取品牌列表
     * @return List<TbBrand>
     */
    @RequestMapping("list")
    @ResponseBody
    public List<TbBrand> getBrandList(){
        log.info("---------------getBrandList------------------");
        return brandService.getAll();
    }

    /**
     * 获取分页列表
     * @param page
     * @param size
     * @return PageResult
     */
    @RequestMapping("findPage")
    @ResponseBody
    public PageResult findPage(int page, int size){
        log.info("---------------获取分页列表------------------");
        PageResult pageResult = brandService.findPage(page,size);
        System.out.println(pageResult);
        return pageResult;
    }

    /**
     * 增加品牌
     * @param tbBrand
     * @return
     */
    @RequestMapping("add")
    @ResponseBody
    public Result add(@RequestBody TbBrand tbBrand){
        try {
            brandService.add(tbBrand);
            return  new Result(true, ConUtils.ADD_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return  new Result(false,ConUtils.ADD_FAIL);
        }
    }

    @RequestMapping("update")
    @ResponseBody
    public Result update(@RequestBody TbBrand tbBrand){
        try {
            brandService.update(tbBrand);
            return  new Result(true,ConUtils.UPDATE_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return  new Result(false,ConUtils.UPDATE_FAIL);
        }
    }

    @RequestMapping("findOne")
    @ResponseBody
    public TbBrand findOne(long id){
        return brandService.findOne(id);
    }

    @RequestMapping("delete")
    @ResponseBody
    public Result delete(Long [] ids){
        try {
            brandService.delete(ids);
            return  new Result(true,ConUtils.DELETE_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return  new Result(false,ConUtils.DELETE_FAIL);
        }
    }

    /**
     * 获取搜索分页列表
     * @param page
     * @param size
     * @return PageResult
     */
    @RequestMapping("search")
    @ResponseBody
    public PageResult search(@RequestBody TbBrand tbBrand,int page, int size){
        log.info("---------------获取搜索分页列表------------------");
        PageResult pageResult = brandService.findPage(tbBrand,page,size);
        System.out.println(pageResult);
        return pageResult;
    }

    @RequestMapping("optionList")
    @ResponseBody
    public List<Map> optionList(){
        return brandService.selectOptionList();
    }
}
