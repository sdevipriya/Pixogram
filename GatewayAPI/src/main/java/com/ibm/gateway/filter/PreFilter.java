package com.ibm.gateway.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpMessage;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.stereotype.Component;

import com.ibm.gateway.feign.client.JwtFeignClient;
import com.ibm.gateway.model.TokenValidate;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;


public class PreFilter extends ZuulFilter {

	@Autowired
	JwtFeignClient feignClient;
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	
	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public Object run() throws ZuulException {
		
		HttpServletRequest request=RequestContext.getCurrentContext().getRequest();  
		String authorizationHeader = null;
        boolean isValidToken=false;
        
		for (Enumeration<?> e = request.getHeaderNames(); e.hasMoreElements();) {
		    String nextHeaderName = (String) e.nextElement();
		    String headerValue = request.getHeader(nextHeaderName);
		    if(nextHeaderName.equals("authorization")) {
		    	authorizationHeader= headerValue;
		    }
		}		
		
		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			String jwtToken = authorizationHeader.substring(7);
        	TokenValidate tokenValidate = new TokenValidate(); 
        	tokenValidate.setToken(jwtToken);
			isValidToken= feignClient.validate(tokenValidate);
			
        }
		else {
			/*
			 * try { // throw an object of user defined exception throw new
			 * UserDefinedException("authentication token is not available"); } catch
			 * (UserDefinedException ude) { System.out.println(ude.getMessage()); }
			 */

	        RequestContext ctx = RequestContext.getCurrentContext();
	         //request = ctx.getRequest();
	         ctx.setSendZuulResponse(false); 
			
	}
		
		if(!isValidToken){
			return null;
		}
		return isValidToken;
	}


}

class UserDefinedException extends Exception  
{  
    public UserDefinedException(String str)  
    {  
        // Calling constructor of parent Exception  
        super(str);  
    }  
}  
