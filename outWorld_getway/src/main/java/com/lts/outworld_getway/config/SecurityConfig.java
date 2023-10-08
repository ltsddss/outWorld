package com.lts.outworld_getway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 忽略登录与注册接口的授权
     *
     * @return
     */
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/ignore1", "/ignore2");
    }
    /**
     * 配置其他接口的访问权限
     */

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
//        web.addSecurityFilterChainBuilder();
    }
}
