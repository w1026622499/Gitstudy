package com.km.controller;

import com.km.domain.User;
import com.km.mapper.UserMapper;
import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @author Wh
 * @title
 * @description
 * @createTime 2021年02月07日 15:18:00
 * @modifier：Wh
 * @modification_time：2021-02-07 15:18
 */
public class Mybatistest
{





        /**
         * @Author: Wh
         * @Date: 2021/2/7 15:19
         * @Description: 根据xml配置文件(全局配置文件) 创建一个SqlsessionFactory对象
         * @Modifier: Wh
         * @Modify_Date: 2021/2/7 15:19
         * @Param: []
         * @Return: void
         */
    public void Mybatistest() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        //获取实例，能直接执行已经映射的语句
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            User object = sqlSession.selectOne("com.km.mapper.UserMapper.selectSpring",1);
            System.out.println(object);
        }finally {
            sqlSession.close();
        }
    }


}
