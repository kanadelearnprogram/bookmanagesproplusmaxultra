package com.book.Service.impl;

import com.book.Mapper.UserMapper;
import com.book.entity.User;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;
import com.book.utils.mybatisUti;

public class UserService implements com.book.Service.UserService {
   public boolean auth(String username, String password, HttpSession session){
try (SqlSession sqlSession= mybatisUti.getSession()){
  UserMapper mapper= sqlSession.getMapper(UserMapper.class);
  User user=mapper.getUser(username,password);
    //System.out.println(user.toString());
  if (user==null){
      return  false;
  }
  session.setAttribute("user",user);
}

        return true;
    }
}
