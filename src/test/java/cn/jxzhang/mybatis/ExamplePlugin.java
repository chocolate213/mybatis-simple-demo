package cn.jxzhang.mybatis;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Properties;

@Intercepts({@Signature(
        type = Executor.class,
        method = "update",
        args = {MappedStatement.class, Object.class})})
public class ExamplePlugin implements Interceptor {
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        Method method = invocation.getMethod();
        Object target = invocation.getTarget();

        System.out.println("args:" + Arrays.toString(args));
        System.out.println("method:" + method);
        System.out.println("target:" + target);

        return invocation.proceed();
    }

    public Object plugin(Object target) {
        System.out.println("plugin: " + target.getClass());
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties) {
        System.out.println("plugin prop: " + properties);
    }
}