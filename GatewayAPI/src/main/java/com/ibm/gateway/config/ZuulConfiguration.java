package com.ibm.gateway.config;
import org.springframework.context.annotation.Bean;

import com.ibm.gateway.filter.PreFilter;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZuulConfiguration {
	
	/*
	 * @Bean public ErrorFilter errorFilter(){ return new ErrorFilter(); }
	 */
	    @Bean
	    public PreFilter preFilter(){
	        return new PreFilter();
	    }

		/*
		 * @Bean public PostFilter postFilter(){ return new PostFilter(); }
		 * 
		 * @Bean public RouteFilter routeFilter(){ return new RouteFilter(); }
		 */
}
