package com.bodyash.pizzaria;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

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
    public void onStartup(ServletContext servletContext) throws ServletException {
        FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("encoding-filter", new CharacterEncodingFilter());
        encodingFilter.setInitParameter("encoding", "UTF-8");
        encodingFilter.setInitParameter("forceEncoding", "true");
        encodingFilter.addMappingForUrlPatterns(null, true, "/*");
    	super.onStartup(servletContext);
    }
    
    @Override
    protected Filter[] getServletFilters() {
    	   // if encoding has issues we need to add UTF-8 encoding filter
    	   CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
    	   encodingFilter.setEncoding("UTF-8");
    	   encodingFilter.setForceEncoding(true);
    	   // encoding filter must be the first one
    	   return new Filter[]{encodingFilter,
    	           new DelegatingFilterProxy("springSecurityFilterChain"),
    	           new OpenEntityManagerInViewFilter()};
    	}
    

}
