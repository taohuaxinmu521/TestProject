package com.pingyougou.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 分页结果类
 * Created by tanwen on 2018/11/11.
 */
public class PageResult implements Serializable {

    private Long total;//总记录数

    private List rows;//当前页记录

    public PageResult(Long total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}