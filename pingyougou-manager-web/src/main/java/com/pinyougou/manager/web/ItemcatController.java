package com.pinyougou.manager.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pingyougou.entity.PageResult;
import com.pingyougou.sellergoods.ItemcatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by tanwen on 2018/11/18.
 */
@Slf4j
@Controller
@RequestMapping("type")
public class ItemcatController {

    @Reference
    ItemcatService itemcatService;

    @RequestMapping("search")
    @ResponseBody
    public PageResult findByParentId(long parentId,int page,int size){
        return itemcatService.findPage(parentId,page,size);
    }

}
