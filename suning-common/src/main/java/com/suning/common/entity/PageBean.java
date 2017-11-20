package com.suning.common.entity;

import java.util.List;

public class PageBean {


    private Integer total;

    private List<?> rows;

    public PageBean() {

    }

    public PageBean(Integer total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }

    public PageBean(Long total, List<?> rows) {
        this.total = total.intValue();
        this.rows = rows;
    }
    
    @Override
	public String toString() {
		return "ItemListVO [total=" + total + ", rows=" + rows + "]";
	}

	public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
