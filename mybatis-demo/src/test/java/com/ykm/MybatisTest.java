package com.ykm;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.entity.User;
import org.example.mapper.UserMapper;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {


    @Test
    public void ykmTest() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        Object o;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            o = sqlSession.selectOne("org.example.mapper.UserMapper.selectUser", 1);
            System.out.printf(o + "");
        }

    }

    @Test
    public void ykmTest2() throws IOException {
        try (InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml")) {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            User user = new User();
            user.setId(4L);
            user.setUserName("TayLor");
            user.setPassword("America");
            int insert = sqlSession.insert("org.example.mapper.UserMapper.insertUser", user);
            System.out.printf(""+ insert);
            Object o = sqlSession.selectOne("org.example.mapper.UserMapper.selectUser", 4L);
            System.out.printf(""+ o);
            sqlSession.close();
        }

    }

    @Test
    public void ykmTest3() {
        try (InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml")) {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            User user = new User();
            user.setId(2L);
            user.setUserName(null);
            user.setPassword("America");
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User byCondition = mapper.selectByCondition(user);
            System.out.printf("" + byCondition);
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void SessionTest() {
        try (InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml")) {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            User user = new User();
            user.setId(1L);
            user.setUserName(null);
            user.setPassword("America");
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User byCondition = mapper.selectByCondition(user);
            System.out.println(byCondition);

            User byCondition2 = mapper.selectByCondition(user);
            System.out.println(byCondition2);
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
