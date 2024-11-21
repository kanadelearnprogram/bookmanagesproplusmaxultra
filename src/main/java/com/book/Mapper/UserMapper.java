package com.book.Mapper;

import com.book.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select *from usermanager where username=#{username} and password=#{password}")
    User getUser(@Param("username") String username,@Param("password") String password);
}
