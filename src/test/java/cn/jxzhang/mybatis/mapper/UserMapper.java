package cn.jxzhang.mybatis.mapper;

import cn.jxzhang.mybatis.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

/**
 * UserMapper
 *
 * @author zhangjiaxing005@ke.com
 */
public interface UserMapper {

    @Select("SELECT * FROM USER WHERE user_id = #{uid}")
    User selectOne(int uid);

    @Select("SELECT * FROM USER")
    List<User> selectAll();

    //以下三个操作等效
    @Select("SELECT * FROM USER where user_age > #{arg0} and user_birthday < #{arg1}")
    List<User> selectList( int age, Date date);

    @Select("SELECT * FROM USER where user_age > #{param1} and user_birthday < #{param2}")
    List<User> selectList3( int age, Date date);

    @Select("SELECT * FROM USER where user_age > #{age} and user_birthday < #{date}")
    List<User> selectList2( @Param("age") int age,  @Param("date") Date date);

    @Insert("INSERT INTO USER (user_name, user_age, user_birthday) VALUE (#{userName}, #{userAge}, #{userBirthday})")
    void insertUser(User user);
}
