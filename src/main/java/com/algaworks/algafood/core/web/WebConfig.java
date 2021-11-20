package com.algaworks.algafood.core.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ShallowEtagHeaderFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.Filter;

@Configuration
public class WebConfig implements WebMvcConfigurer {


	@Autowired
	private ApiRetirementHandler apiRetirementHandler;
	
	//cors no projeto inteiro
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		.allowedMethods("*");
	}

	//método usado para depreciar v1 da api.
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(apiRetirementHandler);
//	}

	//gerar Etag
	@Bean
	public Filter shallowEtagHeaderFilter() {
		return new ShallowEtagHeaderFilter();
	}
}
