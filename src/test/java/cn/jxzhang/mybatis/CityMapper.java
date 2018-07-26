package cn.jxzhang.mybatis;

import cn.jxzhang.mybatis.model.City;

/**
 * CityMapper
 *
 * @author zhangjiaxing005@ke.com
 */
public interface CityMapper {

    City selectCityById(int id);
}
