package cn.jxzhang.mybatis.model;

/**
 * Teacher
 *
 * @author zhangjiaxing
 * @version 1.0
 */
public class Teacher {
    private int teacherId;

    private Gender teacherGender;

    private Subject teacherSubject;

    private Country teacherCountry;

    public Teacher(int teacherId) {
        this.teacherId = teacherId;
    }

    public Country getTeacherCountry() {
        return teacherCountry;
    }

    public void setTeacherCountry(Country teacherCountry) {
        this.teacherCountry = teacherCountry;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public Gender getTeacherGender() {
        return teacherGender;
    }

    public void setTeacherGender(Gender teacherGender) {
        this.teacherGender = teacherGender;
    }

    public Subject getTeacherSubject() {
        return teacherSubject;
    }

    public void setTeacherSubject(Subject teacherSubject) {
        this.teacherSubject = teacherSubject;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", teacherGender=" + teacherGender +
                ", teacherSubject=" + teacherSubject +
                ", teacherCountry=" + teacherCountry +
                '}';
    }
}

