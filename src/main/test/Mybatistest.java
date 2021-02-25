import com.km.domain.User;
import com.km.mapper.UserMapper;
import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

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



    SqlSessionFactory getsqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }

        /**
         * @Author: Wh
         * @Date: 2021/2/7 15:19
         * @Description: 1.根据xml配置文件(全局配置文件) 创建一个SqlsessionFactory对象
         *               2.sql映射文件；配置了每一个sql，以及sql封装的规则等。
         *               3.将sql映射文件注册在全局配置文件中
         *               4.写代码
         *                     1）、根据全局配置文件得到SqlsessionFactory
         *                     2）、使用SqlsessionFactory工厂，获取到SqlsessionFactory对象使用他来执行增删改查
         *                          一个SqlsessionFactory代表一次会话，用完关闭
         *                     3）、使用SqlsessionFactory唯一标识来告诉Mybatis执行那个sql，sql都是保存在sql映射文件中
         * @Modifier: Wh
         * @Modify_Date: 2021/2/7 15:19
         * @Param: []
         * @Return: void
         */
        @Test
    public void Mybatistest() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlsessionFactory实例，能直接执行已经映射的语句
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            User object = sqlSession.selectOne("com.km.mapper.UserMapper.selectSpring",1);
            System.out.println(object);
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void Mybatistest1() throws IOException {
        //1.获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getsqlSessionFactory();
        //2.获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //3.获取接口的实现对象
            //会为接口创建一个代练对象，代理对象去执行增删改查
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.selectSpring(1);
            System.out.println(user);
        } finally {
            sqlSession.close();
        }
    }
}
