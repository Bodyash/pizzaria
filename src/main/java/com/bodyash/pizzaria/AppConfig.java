package com.bodyash.pizzaria;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import com.bodyash.pizzaria.dao.*;
import com.bodyash.pizzaria.service.AccountService;
import com.bodyash.pizzaria.service.CustomAccountDetailService;

@Configuration
@ComponentScan("com.bodyash.pizzaria")
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter {
	
	@Bean(name = "accountDao")
	public AccountDao AccountDao() {
		return new AccountDaoImpl();
	}
	
	@Bean(name = "orderDao")
	public OrderDao OrderDao() {
		return new OrderDaoImpl();
	}
	
	@Bean(name = "pizzaDao")
	public ProductDao ProductDao() {
		return new ProductDaoImpl();
	}
	
	@Bean(name = "CustomAccountDetailService")
	public UserDetailsService AccountDetailService() {
		return new CustomAccountDetailService();
	}
	@Bean(name = "AccountService")
	public AccountService AccountService() {
		return new AccountService();
	}
	
    @Bean
    public UrlBasedViewResolver setupViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        resolver.setOrder(1);
        return resolver;
    }

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        return new CommonsMultipartResolver();
    }
    
    @Bean
    public TilesViewResolver tilesViewResolver() {
        TilesViewResolver resolver = new TilesViewResolver();
        resolver.setViewClass(TilesView.class);
        resolver.setOrder(0);
        return resolver;
    }

    @Bean
    public TilesConfigurer tilesConfig() {
        TilesConfigurer configurer = new TilesConfigurer();
        configurer.setDefinitions("/WEB-INF/tiles/tiles.xml");
        configurer.setCheckRefresh(true); //added
        return configurer;
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.ignoreUnknownPathExtensions(false).defaultContentType(MediaType.TEXT_HTML);
    }

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
}