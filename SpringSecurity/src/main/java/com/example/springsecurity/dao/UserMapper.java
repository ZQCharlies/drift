package com.example.springsecurity.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
/**
 * @Author wzq
 * @Date 2021/9/21
 **/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
