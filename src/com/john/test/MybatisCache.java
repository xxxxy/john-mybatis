package com.john.test;

import com.john.bean.User;
import com.john.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisCache {
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
    public void testFirstCacheLevel() {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(7);
        System.out.println(userById);
        sqlSession.close();

        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        UserMapper mapper1 = sqlSession2.getMapper(UserMapper.class);
        User userById2 = mapper1.getUserById(7);
        System.out.println(userById2);
        sqlSession2.close();

        System.out.println(userById == userById2);
    }
}
