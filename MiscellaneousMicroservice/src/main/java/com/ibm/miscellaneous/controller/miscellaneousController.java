package com.ibm.miscellaneous.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.miscellaneous.dao.BlockedAccountsDao;
import com.ibm.miscellaneous.dao.FollowersDao;
import com.ibm.miscellaneous.model.BlockedAccounts;
import com.ibm.miscellaneous.model.Followers;



@RestController
@RequestMapping("/misc")
public class miscellaneousController {
	
	@Autowired
	private BlockedAccountsDao blockedAccountsDao;
	@Autowired
	private FollowersDao followersDao;
	
	@GetMapping
	public String getEmp(){
		return "Priya";
	}
	
	@GetMapping("/blockedaccounts/{userId}")
	public List<BlockedAccounts> getBlockedUsers(@PathVariable String userId) {
		return blockedAccountsDao.findByUserId(userId);
		
	}
	@GetMapping("/getFollowing/{userId}")
	public List<Followers> getFollowing(@PathVariable String userId) {
		return followersDao.findByUserId(userId);
		
	}
	
	@GetMapping ("/getFollowers/{userId}")
	public List<Followers> getFollowers(@PathVariable String userId) {
		return followersDao.findByFollowsUserId(userId);
	}
	
	@PostMapping ("/follows/{userId}")
	public Followers setFollowers(@PathVariable String userId, @RequestParam String followsUserId) {
		Followers follower = new Followers();
		follower.setUserId(userId);
		follower.setUserId(followsUserId);
		return followersDao.save(follower);
	}
	
	@PostMapping ("/unfollow/{userId}")
	public Followers setUnFollowers(@PathVariable String userId, @RequestParam String followsUserId) {
		Followers follower = followersDao.findByUserIdAndFollowsUserId(userId,followsUserId);
		if(follower!=null) {
			followersDao.delete(follower);
		}
		return follower;
	}
	@PostMapping("/blockuser/{userId}")
	public BlockedAccounts blockUser(@PathVariable String userId, @RequestParam String blockedUserId) {
		BlockedAccounts blockedAccounts = new BlockedAccounts();
		blockedAccounts.setBlockedUserId(blockedUserId);
		blockedAccounts.setUserId(userId);
		return blockedAccountsDao.save(blockedAccounts);
	}
	@PostMapping ("/unblock/{userId}")
	public BlockedAccounts unblock(@PathVariable String userId, @RequestParam String blockedUserId) {
		BlockedAccounts blockedAccounts = blockedAccountsDao.findByUserIdAndBlockedUserId(userId,blockedUserId);
		if(blockedAccounts!=null) {
			blockedAccountsDao.delete(blockedAccounts);
		}
		return blockedAccounts;
	}
}
