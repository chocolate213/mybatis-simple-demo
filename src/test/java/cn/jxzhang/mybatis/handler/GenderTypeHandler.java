package cn.jxzhang.mybatis.handler;

import cn.jxzhang.mybatis.model.Gender;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * GenderTypeHandler
 *
 * 注意：默认的枚举类型处理器会按照名字来处理，例如数据库中存储的是MALE，就会映射到枚举类型的MAIL字段上，所以可以自定义一个枚举类型处理器
 * 不是按照名字来处理的枚举类型处理器
 *
 * @author zhangjiaxing
 * @version 1.0
 */
@MappedTypes(cn.jxzhang.mybatis.model.Gender.class)
@MappedJdbcTypes(JdbcType.INTEGER)
public class GenderTypeHandler extends BaseTypeHandler<Gender> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Gender parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.gender());
    }

    @Override
    public Gender getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return Gender.valueOf(rs.getInt(columnName));
    }

    @Override
    public Gender getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return Gender.valueOf(rs.getInt(columnIndex));
    }

    @Override
    public Gender getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return Gender.valueOf(cs.getInt(columnIndex));
    }
}
