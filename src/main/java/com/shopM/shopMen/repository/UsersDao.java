package com.shopM.shopMen.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopM.shopMen.entity.Users;

public interface UsersDao extends JpaRepository<Users, Long>{
	
	@SuppressWarnings("unchecked")
	Users save(Users users);
	
	Optional<Users> findById(Long userNo);
	
	void deleteById(Long userNo);
	
	Users findByUserAccount(String userAccount);
	
	Users findByUserEmail(String userEmail);
}
