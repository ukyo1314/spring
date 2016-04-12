package com.cn.myspring.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.myspring.mapper.WareExtendMapper;
import com.cn.myspring.mapper.WareMapper;
import com.cn.myspring.po.Ware;
import com.cn.myspring.po.WareExtend;
import com.cn.myspring.po.WareExtendPo;

@Service("wareService")
public class WareService {

    @Autowired  
    private WareMapper wareMapper;  
    @Autowired  
    private WareExtendMapper wareExtendMapper;  
    
    public Ware selectByPrimaryKey(Integer id){
    	
    	 return wareMapper.selectByPrimaryKey(id);
    }
    
    public void updateWareInfo(Ware ware){
    	wareMapper.updateByPrimaryKeySelective(ware);
    }
    
    public void deleterWares(WareExtendPo wareExtendPo){
    	wareExtendMapper.deleterWares(wareExtendPo);
    }
    
    public List<WareExtend> findWaresList(WareExtend wareExtend){
    	List<WareExtend> wareExtends = wareExtendMapper.findWaresList(wareExtend);
		return wareExtends;
    }
    
}
