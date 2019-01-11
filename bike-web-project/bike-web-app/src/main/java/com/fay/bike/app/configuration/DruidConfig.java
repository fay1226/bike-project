package com.fay.bike.app.configuration;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.google.common.collect.Maps;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.Map;

/**
 * 数据库连接测试监控配置
 * @author fanqingfeng
 * @date 2019/1/10 11:48
 */
@Configuration
public class DruidConfig {

    @Bean
    public ServletRegistrationBean<StatViewServlet> statView() {
        Map<String, String> initParams = Maps.newHashMap();
        // IP白名单(没有配置或者为空，则允许所有访问)
        initParams.put("allow", "127.0.0.1,172.16.22.184");
        // IP黑名单 (存在共同时，deny优先于allow)
        initParams.put("deny", "172.16.22.172");
        // 禁用 HTML页面上的 Reset All 功能
        initParams.put("resetEnable", "false");
        initParams.put("loginUsername", "admin");
        initParams.put("loginPassword", "admin");

        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>();
        bean.setServlet(new StatViewServlet());
        bean.setUrlMappings(Collections.singletonList("/druid/*"));
        bean.setInitParameters(initParams);
        return bean;
    }

    @Bean
    public FilterRegistrationBean<WebStatFilter> webStat() {
        Map<String, String> initParams = Maps.newHashMap();
        initParams.put("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");

        FilterRegistrationBean<WebStatFilter> filter = new FilterRegistrationBean<>();
        filter.setFilter(new WebStatFilter());
        filter.setInitParameters(initParams);
        filter.setUrlPatterns(Collections.singletonList("/*"));
        return filter;
    }
}
