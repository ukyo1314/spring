package com.cn.myspring.mapper;

import java.util.List;

import com.cn.myspring.po.AA;
import com.cn.myspring.po.WareAndBusiness;




public interface WareAndBusinessMapper{
	
	List<WareAndBusiness> findWaresNameListByBusinessId();
	
	List<AA> findAAList();
}