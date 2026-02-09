package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.security.JWTFilter;

public class FilterConfig implements WebMvcConfigurer{
	
	@Autowired
	JWTFilter jwtFilter;
	
	@Bean
	public FilterRegistrationBean<JWTFilter> jwtFilterBean() {
	    FilterRegistrationBean<JWTFilter> reg = new FilterRegistrationBean<>();
	    reg.setFilter(jwtFilter);
	    reg.addUrlPatterns("/api/*");
	    reg.setOrder(1); // highest priority
	    return reg;
	}

}
