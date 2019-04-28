package com.pinyougou.manager.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pingyougou.common.ConUtils;
import com.pingyougou.entity.PageResult;
import com.pingyougou.entity.Result;
import com.pingyougou.pojo.TbSeller;
import com.pingyougou.sellergoods.SellerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by tanwen on 2018/11/18.
 */
@Slf4j
@Controller
@RequestMapping("seller")
public class SellerController {

    @Reference
    SellerService sellerService;

    @RequestMapping("search")
    @ResponseBody
    public PageResult search(@RequestBody TbSeller seller, int page, int size){
        log.info("---------------获取搜索分页列表------------------");
        PageResult pageResult = sellerService.findPage(seller,page,size);
        System.out.println(pageResult);
        return pageResult;
    }

    @RequestMapping("findOne")
    @ResponseBody
    public TbSeller findOne(String id){
        return sellerService.findOne(id);
    }

    @RequestMapping("updateStatus")
    @ResponseBody
    public Result updateStatus(String sellerId,String status){
        try {
            sellerService.updateStatus(sellerId,status);
            return  new Result(true,ConUtils.UPDATE_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return  new Result(false, ConUtils.UPDATE_FAIL);
        }
    }
}
