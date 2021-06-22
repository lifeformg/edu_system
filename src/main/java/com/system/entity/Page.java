package com.system.entity;

public class Page {
    private Integer pageNow;

    private Integer pageSize;

    private Integer pageTotal;

    private Integer pageIndex;

    public Page(Integer pageNow,Integer pageTotal,Integer pageSize) {
        this.pageNow = pageNow;
        this.pageTotal = pageTotal;
        this.pageSize = pageSize;
    }

    public Page(Integer pageNow,Integer pageTotal) {
        this.pageNow = pageNow;
        this.pageTotal = pageTotal;
        this.pageSize = 10;
    }

    public Integer getPageNow() {
        return pageNow;
    }

    public void setPageNow(Integer pageNow) {
        this.pageNow = pageNow;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void calPageIndex() {
        pageIndex = pageSize * (pageNow-1);
    }
}
