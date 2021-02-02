package com.john.test;

import com.john.bean.Department;
import com.john.bean.User;
import com.john.mapper.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
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

    @Test
    public void testDynamic() {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserDynamicMapper mapper = sqlSession.getMapper(UserDynamicMapper.class);
        User user = new User(null,0, "zhangsan2","john@email2.com", "test" ,new Department(1));
        User user2 = new User(null,0, "zhangsan3","john@email3.com", "test" ,new Department(2));

        //User userByCondition = mapper.getUserByCondition(user);
        //User userByCondition = mapper.getUserByCondition3(user);
        //Integer integer = mapper.updateUserByCondition(user);
        //List<User> userList = mapper.getUsersByIds(Arrays.asList(7, 8, 9));

        Integer integer = mapper.batchSaveUsers(Arrays.asList(user, user2));
        System.out.println(integer);
    }
}
