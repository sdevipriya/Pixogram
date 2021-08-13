package com.ibm.miscellaneous.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.miscellaneous.model.BlockedAccounts;
import com.ibm.miscellaneous.model.Followers;

@Repository
public interface FollowersDao extends JpaRepository<Followers, Integer> {

	List<Followers> findByUserId(String userId);

	List<Followers> findByFollowsUserId(String followsUserId);

	Followers findByUserIdAndFollowsUserId(String userId, String followsUserId);

}
