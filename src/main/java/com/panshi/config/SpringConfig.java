package com.panshi.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.beans.PropertyVetoException;

/**
 * @author lqp
 * @date 2021 6-20
 * @version 1.0
 */
@Configuration
@MapperScan("com.panshi.dao")
@ComponentScan(value={"com.panshi"})
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfig {
    @Value("${driver}")
    private String  driver;
    @Value("${url}")
    private String url;
    @Value("${user_name}")
    private String user_name;
    @Value("${password}")
    private String password;
    @Bean("dataSource")
    public ComboPooledDataSource comboPooledDataSource() throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(user_name);
        comboPooledDataSource.setPassword(password);
        return comboPooledDataSource;
    }
    @Bean("sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(ComboPooledDataSource comboPooledDataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean =new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(comboPooledDataSource);
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setConfigLocation(resourcePatternResolver.getResource("classpath:mybatis.xml"));
        return sqlSessionFactoryBean.getObject();
    }
    @Bean("sqlSession")
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
        return sqlSessionTemplate;
    }

}
