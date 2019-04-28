package com.pingyougou.sellergoods;

import com.pingyougou.entity.PageResult;

/**
 * Created by tanwen on 2018/11/18.
 */
public interface ItemcatService {

    PageResult findPage(long parentId, int pageNum, int pageSize);
}
