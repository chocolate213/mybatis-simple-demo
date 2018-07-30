package cn.jxzhang.mybatis.model;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Student
 *
 * @author zhangjiaxing
 * @version 1.0
 */
public class Student {

    private Integer studentId;

    private String studentName;

    private Integer studentAge;

    private City city;

    private City anotherCity;

    private List<Post> posts;

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public City getAnotherCity() {
        return anotherCity;
    }

    public void setAnotherCity(City anotherCity) {
        this.anotherCity = anotherCity;
    }

    public Student() {
        System.out.println("student constructor without arg");
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentAge=" + studentAge +
                ", city=" + city +
                ", anotherCity=" + anotherCity +
                ", posts=" + posts +
                '}';
    }

    /**
     * 你可以添加 @Param 注解，或者使用 '-parameters' 编译选项并启用 useActualParamName 选项（默认开启）来编译项目。
     */
    public Student(@Param("studentId") Integer studentId,
                   @Param("studentName") String studentName,
                   @Param("studentAge") Integer studentAge) {
        System.out.println("student constructor with arg");

        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAge = studentAge;
    }

    public Student(String studentName, Integer studentAge) {
        this.studentName = studentName;
        this.studentAge = studentAge;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }
}
