package com.example.springbootshiro.mapper;

import com.example.springbootshiro.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user where username = #{username} and password = #{password}")
    User getOne(String username, String password);

}
