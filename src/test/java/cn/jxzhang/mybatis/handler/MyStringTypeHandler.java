package cn.jxzhang.mybatis.handler;

import org.apache.ibatis.type.*;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * MyStringTypeHandler
 *
 * 该TypeHandler将会替换掉Mybatis默认的String类型的TypeHandler
 *
 * 1. 使用这个的类型处理器将会覆盖已经存在的处理 Java 的 String 类型属性和 VARCHAR 参数及结果的类型处理器。 
 * 通过类型处理器的泛型，MyBatis 可以得知该类型处理器处理的 Java 类型，不过这种行为可以通过两种方法改变：
 *
 *   1) 在类型处理器的配置元素（typeHandler element）上增加一个 javaType 属性（比如：javaType="String"）；
 *   在类型处理器的类上（TypeHandler class）增加一个 @MappedTypes 注解来指定与其关联的 Java 类型列表。 如果在 javaType 属性中也同时指
 *   定，则注解方式将被忽略。
 *   可以通过两种方式来指定被关联的 JDBC 类型：
 *
 *   2) 在类型处理器的配置元素上增加一个 jdbcType 属性（比如：jdbcType="VARCHAR"）；
 *   在类型处理器的类上（TypeHandler class）增加一个 @MappedJdbcTypes 注解来指定与其关联的 JDBC 类型列表。 如果在 jdbcType 属性中也同
 *   时指定，则注解方式将被忽略。JdbcType中指定了Jdbc所支持的数据类型
 * 
 * @author zhangjiaxing
 * @version 1.0
 */
@MappedJdbcTypes(JdbcType.VARCHAR)
@MappedTypes(String.class)
public class MyStringTypeHandler extends BaseTypeHandler<String> {

    /**
     * 设置参数
     */
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        System.out.println("string type handler 1");
        ps.setString(i, parameter);
    }

    /**
     * 取回参数
     */
    @Override
    public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
        System.out.println("string type handler 2");
        return rs.getString(columnName);
    }

    /**
     * 取回参数
     */
    @Override
    public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        System.out.println("string type handler 3");
        return rs.getString(columnIndex);
    }

    /**
     * 取回参数
     */
    @Override
    public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        System.out.println("string type handler 4");
        return cs.getString(columnIndex);
    }
}
