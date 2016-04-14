package com.cn.myspring.po;

import java.util.List;



public class WareAndBusiness{
	
    private Integer businessid;
	
    private List<WareExtend> list;

	public Integer getBusinessid() {
		return businessid;
	}

	public void setBusinessid(Integer businessid) {
		this.businessid = businessid;
	}

	public List<WareExtend> getList() {
		return list;
	}

	public void setList(List<WareExtend> list) {
		this.list = list;
	}
	
	
	
}