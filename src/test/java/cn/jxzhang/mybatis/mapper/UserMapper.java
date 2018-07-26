package cn.jxzhang.mybatis.mapper;

import cn.jxzhang.mybatis.model.User;
import org.apache.ibatis.annotations.Select;

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
}
