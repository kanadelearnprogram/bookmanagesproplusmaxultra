package com.book.Service.impl;

import com.book.Mapper.BookMapper;
import com.book.Mapper.StudentMapper;
import com.book.Service.StudentService;
import com.book.entity.Student;
import com.book.utils.mybatisUti;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/*public class StudentServiceImp implements StudentService {
    @Override
    public List<Student> getStudentList() {
        try(SqlSession sqlSession = mybatisUti.getSession()){
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            return mapper.getStudentList();
        }
    }


}*/
