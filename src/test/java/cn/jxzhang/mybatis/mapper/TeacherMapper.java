package cn.jxzhang.mybatis.mapper;

import cn.jxzhang.mybatis.model.Teacher;

/**
 * TeacherMapper
 *
 * @author zhangjiaxing
 * @version 1.0
 */
public interface TeacherMapper {

    Teacher selectTeacherById(int id);
}
