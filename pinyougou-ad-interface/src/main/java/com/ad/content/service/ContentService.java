package com.ad.content.service;

import com.pingyougou.pojo.TbContent;

import java.util.List;

/**
 * Created by tanwen on 2018/12/1.
 */
public interface ContentService {

    List<TbContent> findAll();

    List<TbContent> findByCategoryId(long categoryId);
}
