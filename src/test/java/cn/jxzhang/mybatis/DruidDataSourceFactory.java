package cn.jxzhang.mybatis;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * DruidDataSourceFactory
 *
 * @author zhangjiaxing005@ke.com
 */
public class DruidDataSourceFactory implements DataSourceFactory {

    private Properties properties;

    @Override
    public void setProperties(Properties props) {
        this.properties = props;
    }

    @Override
    public DataSource getDataSource() {
        DruidDataSource druidDataSourceFactory = new DruidDataSource();
        druidDataSourceFactory.setUsername(properties.getProperty("username"));
        druidDataSourceFactory.setPassword(properties.getProperty("password"));
        druidDataSourceFactory.setUrl(properties.getProperty("url"));
        druidDataSourceFactory.setDriverClassName(properties.getProperty("driver"));
        return druidDataSourceFactory;
    }
}
