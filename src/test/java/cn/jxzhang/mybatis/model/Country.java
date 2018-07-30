package cn.jxzhang.mybatis.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Country
 *
 * @author zhangjiaxing
 * @version 1.0
 */
public enum Country {

    CN(1), US(2);

    private static final Map<Integer, Country> COUNTRY_MAP = new HashMap<>();

    static {
        for (Country c : values()) {
            COUNTRY_MAP.put(c.country, c);
        }
    }

    private final int country;

    Country(int country) {
        this.country = country;
    }

    public static Country ofCountry(int country) {
        return COUNTRY_MAP.get(country);
    }
}
