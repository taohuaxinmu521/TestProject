package com.protal.web.controller;

import com.ad.content.service.ContentService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.pingyougou.pojo.TbContent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by tanwen on 2018/12/2.
 */
@Slf4j
@RestController
@RequestMapping("content")
public class ContentController {

    @Reference
    ContentService contentService;

   /* @Autowired
    StringRedisTemplate redisTemplate;*/

    @Autowired
    RedisTemplate redisTemplate;

    int id = 1;

    @RequestMapping("findByCategoryId")
    public List<TbContent> findByCategoryId(long categoryId){
        List<TbContent> list = contentService.findByCategoryId(categoryId);
        //redisTemplate.boundHashOps("content").put(id,list);
        return list;
    }

    @RequestMapping("redis")
    public String testRedis(){
        redisTemplate.opsForValue().set("name","谈闻");
        String str = (String) redisTemplate.opsForValue().get("name");
        System.out.println(str);
        System.out.println("----------------------");
        List<TbContent> list = (List<TbContent>)redisTemplate.boundHashOps("content").get(id);
        System.out.println(list);
        return "success";
    }
}
