package cn.jxzhang.mybatis.model;

import java.util.Date;

/**
 * User
 *
 * @author zhangjiaxing005@ke.com
 */
public class User {

    public User() {
    }

    public User(int userId, String userName, int userAge, Date userBirthday) {
        this.userId = userId;
        this.userName = userName;
        this.userAge = userAge;
        this.userBirthday = userBirthday;
    }

    public User(String userName, int userAge, Date userBirthday) {
        this.userName = userName;
        this.userAge = userAge;
        this.userBirthday = userBirthday;
    }

    private int userId;

    private String userName;

    private int userAge;

    private Date userBirthday;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", userBirthday=" + userBirthday +
                '}';
    }
}
