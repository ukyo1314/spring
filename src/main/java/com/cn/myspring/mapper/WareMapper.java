package com.cn.myspring.mapper;

import com.cn.myspring.po.Ware;

public interface WareMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Ware record);

    int insertSelective(Ware record);

    Ware selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Ware record);

    int updateByPrimaryKeyWithBLOBs(Ware record);

    int updateByPrimaryKey(Ware record);
}