package com.xza.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author 拾柒
 * @create 2020/3/19
 */
@Configuration
public class DruidConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(){
        return new DruidDataSource();
    }

    //注册后台监控页面。SpringBoot如何注册Servlet
    //没有web.xml的情况下配置Servlet的方法
    @Bean
    public ServletRegistrationBean statViewServlet(){
        //StatViewServlet配置后台监控
        ServletRegistrationBean bean=new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        HashMap<String,String> map=new HashMap<>();
        map.put("loginUsername","admin");
        map.put("loginPassword","123456");

        //访问权限
        map.put("allow","");

        bean.setInitParameters(map);
        return bean;
    }

    //过滤器
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean=new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());

        HashMap<String,String> map=new HashMap<>();
        map.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(map);

        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }
}
