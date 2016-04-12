package com.cn.myspring.mapper;

import java.util.List;

import com.cn.myspring.po.WareExtend;
import com.cn.myspring.po.WareExtendPo;


public interface WareExtendMapper {
    List<WareExtend> findWaresList(WareExtend wareExtend);
    
    Integer deleterWares(WareExtendPo wareExtendPo);
}