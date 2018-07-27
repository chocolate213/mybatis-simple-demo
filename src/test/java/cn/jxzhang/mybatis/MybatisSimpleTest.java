package cn.jxzhang.mybatis;

import cn.jxzhang.mybatis.mapper.StudentMapper;
import cn.jxzhang.mybatis.mapper.UserMapper;
import cn.jxzhang.mybatis.model.City;
import cn.jxzhang.mybatis.model.Student;
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
import java.util.*;

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
     * 测试MyBatis一级缓存：缓存刷新条件
     *
     * 1. 所有select操作都会被缓存
     * 2. insert update delete会刷新缓存
     * 3. 缓存会使用LRU策略回收
     * 4. 缓存会根据指定的时间间隔来刷新
     * 5. 缓存会存储1024个对象
     */
    @Test
    public void test32() {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectOne(1);
        sqlSession.clearCache();
        User user2 = mapper.selectOne(1);
    }

    /**
     * 演示插入操作会导致缓存刷新
     */
    @Test
    public void test33() {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectOne(1);
        mapper.insertUser(new User("wangWu", 11, new Date()));
        User user2 = mapper.selectOne(1);
        sqlSession.commit();
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
        List<User> users3 = mapper.selectList3(1, DateTime.now().toDate());
        System.out.println(users);
        System.out.println(users2);
        System.out.println(users3);
    }


    /**
     * Mapper XML文件
     */
    @Test
    public void test5() {
        SqlSession sqlSession = factory.openSession();
        Student o = sqlSession.selectOne("cn.jxzhang.mybatis.StudentMapper.selectStudentById", 1);
        System.out.println(o);
    }

    /**
     * test return map
     */
    @Test
    public void test6() {
        SqlSession sqlSession = factory.openSession();
        Map o = sqlSession.selectOne("cn.jxzhang.mybatis.StudentMapper.selectStudentById", 1);
        System.out.println(o);
    }

    /**
     * test insert
     */
    @Test
    public void test7() {
        SqlSession sqlSession = factory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        mapper.insertStudent(new Student("zhangSan", new Random().nextInt(100)));
        sqlSession.commit();
    }

    /**
     * test update
     */
    @Test
    public void test8() {
        SqlSession sqlSession = factory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        mapper.updateStudent(new Student(1, "liSi", new Random().nextInt(100)));
        sqlSession.commit();
    }

    /**
     * test delete
     */
    @Test
    public void test9() {
        SqlSession sqlSession = factory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        mapper.deleteStudent(new Student(1, "zhangSan", new Random().nextInt(100)));
        sqlSession.commit();
    }

    /**
     * test insert and generate key
     */
    @Test
    public void test10() {
        SqlSession sqlSession = factory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        mapper.insertStudent2(new Student("zhangSanSanSan", new Random().nextInt(100)));
        sqlSession.commit();
    }

    /**
     * test batch insert
     */
    @Test
    public void test11() {
        SqlSession sqlSession = factory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        mapper.insertStudents(Arrays.asList(
                new Student("name1", 1),
                new Student("name2", 2),
                new Student("name3", 3),
                new Student("name4", 4)
        ));

        sqlSession.commit();
    }

    /**
     * test batch insert
     */
    @Test
    public void test12() {
        SqlSession sqlSession = factory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        Student student = mapper.selectStudentById3(5);

        System.out.println(student);

        sqlSession.commit();
    }

    /**
     * test alias
     */
    @Test
    public void test13() {
        SqlSession sqlSession = factory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Map map = mapper.selectStudents2();
        System.out.println(map);

    }

    /**
     * 测试插入空值。注意：
     * 1. pojo中一定不要使用基本数据类型，例如int初始化值为0
     * 2. 如果数据库数据允许null值，那就必须在Mapper中指定jdbcTYpe
     */
    @Test
    public void test14() {
        SqlSession sqlSession = factory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        mapper.insertStudent3(new Student());

        sqlSession.commit();
    }

    /**
     * <!-- ${} 将不会使用 PrepareStatement中的？作为占位符-->
     */
    @Test
    public void test15() {
        SqlSession sqlSession = factory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> students = mapper.selectStudents("student_age");
        System.out.println(students);

    }
}
