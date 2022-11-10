package com.lts.outworld_getway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
public class gatecorsConfigration {

    @Bean
    public CorsWebFilter corsWebFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration corsConfiguration = new CorsConfiguration();

//        允许任何来源进行跨域
        corsConfiguration.addAllowedOrigin("*");

//        允许任何方法进行跨域
        corsConfiguration.addAllowedMethod("*");

//        允许任何请求头进行跨域
        corsConfiguration.addAllowedHeader("*");

//        允许携带cookie跨域
        corsConfiguration.setAllowCredentials(true);

        source.registerCorsConfiguration("/**", corsConfiguration);

        return new CorsWebFilter(source);
    }
}
