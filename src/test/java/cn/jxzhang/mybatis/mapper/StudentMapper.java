package cn.jxzhang.mybatis.mapper;

import cn.jxzhang.mybatis.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * StudentMapper
 *
 * @author zhangjiaxing
 * @version 1.0
 */
public interface StudentMapper {

    void deleteStudent(Student student);

    void updateStudent(Student student);

    void insertStudent(Student student);

    void insertStudent2(Student student);

    void insertStudent3(Student student);

    void insertStudents(List<Student> student);

    Student selectStudentById3(int studentId);

    List<Student> selectStudents(@Param("student_age") String column);

    Map selectStudents2();
}
