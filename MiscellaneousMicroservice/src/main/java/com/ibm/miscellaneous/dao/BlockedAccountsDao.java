package com.ibm.miscellaneous.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ibm.miscellaneous.model.BlockedAccounts;

@Repository
public interface BlockedAccountsDao extends JpaRepository<BlockedAccounts, Integer> {

	List<BlockedAccounts> findByUserId(String userId);

	BlockedAccounts findByUserIdAndBlockedUserId(String userId, String blockedUserId);

}
