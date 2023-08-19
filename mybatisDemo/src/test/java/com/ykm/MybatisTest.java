package com.ykm;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
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
            o = sqlSession.selectOne("UserMapper.selectUser", 1);
        }
        System.out.printf(o + "");

    }
}
