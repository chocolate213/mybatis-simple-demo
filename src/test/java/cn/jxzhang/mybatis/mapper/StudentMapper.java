package cn.jxzhang.mybatis.mapper;

import cn.jxzhang.mybatis.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * StudentMapper
 *
 *
 * 你可以传递多个参数给一个映射器方法。如果你这样做了，默认情况下它们将会以 "param"
 * 字符串紧跟着它们在参数列表中的位置来命名，比如：#{param1}、#{param2}等。如果
 * 你想改变参数的名称（只在多参数情况下），那么你可以在参数上使用 @Param("paramName") 注解。
 *
 * 你也可以给方法传递一个 RowBounds 实例来限制查询结果。
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

    Student selectStudentByIdAndName(Student student);

    Student selectStudentByIdAndName2(Map<String, Object> student);

    Map<String, Object> selectStudentReturnMap(Map<String, Object> student);

    Map<String, Object> selectStudentReturnMap2(Map<String, Object> student);

    Student selectStudentReturnResultMap(Map<String, Object> student);

    Student selectStudentReturnResultMap2(Map<String, Object> student);

    Student selectStudentReturnResultMap3(Map<String, Object> student);

    Student selectStudentWithCity(Map<String, Object> student);

    Student selectStudentWithCity2(Map<String, Object> student);

    Student selectStudentWithCity3(Map<String, Object> student);

    List<Student> findStudentWithNameLike(Student student);

    List<Student> findStudentWithNameLike2(Student student);

    List<Student> findStudentWithWhere(Student student);

    /**
     * 如果不使用@Param参数，则有两个可用参数来表示：[collection, list](在Mapper文件中使用这两个参数可以取到对应的集合)
     */
    List<Student> findStudentWithForEach(@Param("studentIds") List<Integer> studentIds);

    /**
     * 如果不使用@Param参数，则有两个可用参数来表示：[collection, list](在Mapper文件中使用这两个参数可以取到对应的集合)
     */
    List<Student> findStudentWithForEachAndMapParam(@Param("studentIds") Map<Integer, Integer> studentIds);

    /**
     * 返回受影响的行数
     */
    int updateStudentWithSet(Student student);

    List<Student> findStudentWithBindProperty(Student student);
}
