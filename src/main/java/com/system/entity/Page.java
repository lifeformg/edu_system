package com.system.entity;

public class Page {
    private Integer pageNow;

    private Integer pageSize;

    private Integer pageTotal;

    private Integer pageIndex;

    private String jumpLink;

    public static Integer defaultPageSize=3;

    public Page(Integer pageNow,Integer pageTotal,Integer pageSize) {
        this.pageNow = pageNow;
        this.pageTotal = pageTotal;
        this.pageSize = pageSize;
    }

    public Page(Integer pageNow,Integer pageTotal) {
        this.pageNow = pageNow;
        this.pageTotal = pageTotal;
        this.pageSize = Page.defaultPageSize;
    }

    public static Page pageElement(Integer page, Integer pageTotal, Integer pageSize, String jumpLink) {
        if(page == null || page<=0){
            page = 1;
        }

        if(page> pageTotal)
            page = pageTotal;
        Page topage = new Page(page, pageTotal,pageSize);
        topage.setJumpLink(jumpLink);
        return topage;
    }

    public static Page pageElement(Integer page, Integer pageTotal, String jumpLink) {
        return pageElement(page,pageTotal,defaultPageSize,jumpLink);
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

    public String getJumpLink() {
        return jumpLink;
    }

    public void setJumpLink(String jumpLink) {
        this.jumpLink = jumpLink;
    }
}
