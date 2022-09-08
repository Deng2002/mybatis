package com.fang.mybatis.test;

import com.fang.mybatis.mapper.UserMapper;
import com.fang.mybatis.pojo.User;
import com.fang.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {
    @Test
    public void testInsert() throws IOException {

        InputStream is = Resources.getResourceAsStream("mybatis-configs.xml");

        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = build.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int result = mapper.insertUser();
        System.out.println("结果"+result);
        //提交事务
        sqlSession.commit();
        //关闭会话
        sqlSession.close();
    }
    @Test
    public void testUpdate(){
        //获取会话
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updataUser();
        //结束会话
        sqlSession.close();
    }
    @Test
    public void testDelete(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser();
        sqlSession.close();
    }
    @Test
    public void testQueryUserByUsername(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserByUsername("root");
        System.out.println(user);
        sqlSession.close();
    }
    @Test
    public void testCheckUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkUser("root", "1111");
        System.out.println(user);
        sqlSession.close();
    }
}
