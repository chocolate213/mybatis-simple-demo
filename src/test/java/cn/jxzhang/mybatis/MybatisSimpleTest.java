package cn.jxzhang.mybatis;

import cn.jxzhang.mybatis.mapper.UserMapper;
import cn.jxzhang.mybatis.model.City;
import cn.jxzhang.mybatis.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * MybatisSimpleTest
 *
 * @author zhangjiaxing005@ke.com
 */
public class MybatisSimpleTest {

    private SqlSessionFactory factory;

    @Before
    public void init() throws IOException {
        String CONF_PATH = "conf/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(CONF_PATH);
        factory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * 1. 从 XML 中构建 SqlSessionFactory
     */
    @Test
    public void test1() {
        SqlSession sqlSession = factory.openSession();

        CityMapper mapper = sqlSession.getMapper(CityMapper.class);

        City city = mapper.selectCityById(1);
        System.out.println(city);

        sqlSession.close();
    }


    /**
     * 2. 配置文件配置
     */
    @Test
    public void test2() {

    }

    /**
     * 测试MyBatis一级缓存：缓存会话中的所有查询，如果将scope修改为STATEMENT，将会看到相同查询会请求两次数据库
     */
    @Test
    public void test3() {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectOne(1);
        System.out.println(user);
        User user2 = mapper.selectOne(1);
        System.out.println(user2);
    }

    /**
     * 测试查询所有
     */
    @Test
    public void test4() {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectAll();
        System.out.println(users);
    }

    /**
     * 测试查询所有
     */
    @Test
    public void test41() {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectList(0, DateTime.now().toDate());
        List<User> users2 = mapper.selectList2(0, DateTime.now().toDate());
        List<User> users3 = mapper.selectList3(0, DateTime.now().toDate());
        System.out.println(users);
        System.out.println(users2);
        System.out.println(users3);
    }


    /**
     * Mapper XML文件
     */
    @Test
    public void test5() {

    }
}
