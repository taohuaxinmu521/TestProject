package com.pinyougou.manager.web;

import com.ad.content.service.ContentService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.pingyougou.pojo.TbContent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by tanwen on 2018/12/1.
 */
@Slf4j
@Controller
@RequestMapping("content")
public class ContentController {

    @Reference
    ContentService contentService;

    @RequestMapping("list")
    @ResponseBody
    public List<TbContent> findAll(){
        List<TbContent> list = contentService.findAll();
        System.out.println(list);
        return list;
    }
}
