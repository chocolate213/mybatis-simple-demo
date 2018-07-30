package cn.jxzhang.mybatis.model;

/**
 * Gender
 *
 * @author zhangjiaxing
 * @version 1.0
 */
public enum Gender {
    MALE(1, "male"), FEMALE(2, "female");

    private final int gender;

    private final String desc;

    Gender(int gender, String desc) {
        this.gender = gender;
        this.desc = desc;
    }

    public static Gender valueOf(int gender) {
        for (Gender g : values()) {
            if (g.gender() == gender) {
                return g;
            }
        }

        throw new IllegalArgumentException();
    }

    public int gender() {
        return this.gender;
    }

    public String desc() {
        return this.desc;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "gender=" + gender +
                ", desc='" + desc + '\'' +
                '}';
    }
}