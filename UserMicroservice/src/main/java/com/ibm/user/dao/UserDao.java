package com.ibm.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ibm.user.model.Users;

public interface UserDao extends JpaRepository<Users, Integer>{

	Users findByuserName(String userName);

}
