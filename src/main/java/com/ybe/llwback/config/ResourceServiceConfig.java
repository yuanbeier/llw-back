package com.ybe.llwback.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @author: beier
 * @date: 2020/9/9
 * @description: 资源服务类
 * @version: 1.0
 */
@Configuration
@EnableResourceServer
@Slf4j
public class ResourceServiceConfig extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        super.configure(resources);
        resources.resourceId("llwback").stateless(true);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        log.info("ResourceServerConfig中配置HttpSecurity对象执行");

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/yy/**").permitAll()
                .anyRequest()
                .authenticated();

    }
}
