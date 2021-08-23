package com.ibm.user.controller;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.user.dao.UserDao;
import com.ibm.user.feign.client.JwtFeignClient;
import com.ibm.user.model.JwtRequest;
import com.ibm.user.model.Users;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class LoginController {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private JwtFeignClient jwtFeignClient;
	
	
	@GetMapping("/msg")
	public String getMessage() {
		return "Hello";
	}
	@PostMapping("/signup")
	public String signUpUser(@RequestBody Users user) {
		System.out.println("in signup method");
		Users usr = userDao.findByuserName(user.getUserName());
		System.out.println("user: "+usr);
		if(usr==null) {
		userDao.save(user);
		return "Registered successfully";
		}
		else
			return "user already exists";
	}
	@GetMapping("/checkUp")
	public Boolean checkUp(@RequestParam String userName) {
		Users user = userDao.findByuserName(userName);
		if(user==null)
		return true;
		else
			return false;
	}
	
	@PostMapping("/updateUser")
	public String updateUser(@RequestBody Users user) {
		
		Users usr = userDao.findByuserName(user.getUserName());
		usr.setId(user.getId());
		usr.setUserName(user.getUserName());
		usr.setPassword(user.getPassword());
		usr.setConfirm(user.getConfirm());
		usr.setUserId(user.getUserId());
		usr.setProfilePictureUrl(user.getProfilePictureUrl());
		usr.setCreatedDateTime(user.getCreatedDateTime());
		userDao.save(usr);
		return "updated successfully";
	}
	
	@PostMapping("/login")
//	public Boolean loginUser(@RequestParam String userName, @RequestParam String password) {
	public Users loginUser(@RequestBody Users user) {
	Users usr = userDao.findByuserNameAndPassword(user.getUserName(), user.getPassword());
		System.out.println("uname : "+user.getUserName());
		System.out.println("pwd : "+user.getPassword());
		System.out.println("usr.getPassword(): "+usr.getPassword());
//		if(usr!=null && usr.getPassword().equals(user.getPassword()))
//		{System.out.println("logged in"+usr);
//		
//		return usr;
//		}else { 
//			System.out.println("unable to login"+usr);
//			return usr;
//			
//	}
	//	System.out.println("")
		
		JwtRequest jwtRequest = new JwtRequest();
		jwtRequest.setUserName(user.getUserName());
		String token = jwtFeignClient.authenticate(jwtRequest);
		System.out.println("token:"+token);
		HttpHeaders headers = new HttpHeaders();
		headers.set("auth", token);
		usr.setToken(token);
		userDao.save(usr);
		return usr;
	}
	

}
