package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.demo.model.UserAccount;


public interface UserAccountRepository  extends JpaRepository<UserAccount,Long>{

	boolean existsByUserId(Long userId);

}
