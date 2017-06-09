package com.bodyash.pizzaria;

import javax.servlet.Filter;

import org.springframework.core.annotation.Order;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Order(1)
public class WebInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AppConfig.class, SecurityConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
    
    @Override
    protected Filter[] getServletFilters() {
    	   // if encoding has issues we need to add UTF-8 encoding filter
    	   CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
    	   encodingFilter.setForceEncoding(true);
    	   encodingFilter.setEncoding("UTF-8");
    	   // encoding filter must be the first one
    	   return new Filter[]{encodingFilter,
    	           new DelegatingFilterProxy("springSecurityFilterChain"),
    	           new OpenEntityManagerInViewFilter()};
    	}
    

}
