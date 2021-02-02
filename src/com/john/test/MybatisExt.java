package com.john.test;

import com.john.bean.Department;
import com.john.bean.User;
import com.john.mapper.DepartmentMapper;
import com.john.mapper.UserMapper;
import com.john.mapper.UserMapperAnnotation;
import com.john.mapper.UserMapperExt;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class MybatisExt {
    public SqlSessionFactory getSqlSessionFactory() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testUser() {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapperExt mapper = sqlSession.getMapper(UserMapperExt.class);
        //User userById = mapper.getById(1);
        //User userWithDept = mapper.getUserWithDept(7);
        User userWithDept = mapper.getByIdStep(7);
        System.out.println(userWithDept.getEmail());
    }

    @Test
    public void testDept() {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        Department departmentPlus = mapper.getDepartmentStep(1);
        System.out.println(departmentPlus.getName());
    }
}
