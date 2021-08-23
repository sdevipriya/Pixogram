package com.ibm.gateway.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ibm.gateway.model.TokenValidate;


@FeignClient(name="AuthenticationService", url="http://localhost:8080")
public interface JwtFeignClient {

	@RequestMapping(method= RequestMethod.POST ,value="/auth/validate")
	public boolean validate(@ModelAttribute TokenValidate tokenValidate);
}
