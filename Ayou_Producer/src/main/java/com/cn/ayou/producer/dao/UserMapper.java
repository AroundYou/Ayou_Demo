package com.cn.ayou.producer.dao;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName UserMapper
 * @Deseiption
 * @Author AYOU
 * @Date 2019/7/19 18:17
 * @Version 1.0
 **/
@Mapper
public interface UserMapper {

    @Insert("insert * from 表 滴滴滴")
    int insert();
}
