package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.UserAccountDto;
import com.demo.model.UserAccount;
import com.demo.service.UserAccountService;

@RestController
public class UserAccountController {

	@Autowired
	private UserAccountService userAccountService;
	
	@PostMapping("api/v1/userAccount")
	public void addUserAccountDetail(@RequestBody  UserAccountDto userAccountDto) {
		UserAccount userAccountDetails=userAccountService.addUserAccountDetails(userAccountDto);
	}
	
	@GetMapping("api/v1/userAccount/{userId}")
	public UserAccount getUserAccountDetail(@PathVariable("userId")  Long userId) {
		UserAccount userAccountDetails=userAccountService.getUserAccountDetail(userId);
		return userAccountDetails;
	}
	
	@GetMapping("api/v1/userAccount")
	public void getAllUserAccountDetail() {
		List<UserAccount> allUserAccountDetails=userAccountService.getAllUserAccountDetail();
		System.out.println("rrrrrrrrr"+allUserAccountDetails);
	}
	
	@GetMapping("api/v1/userAccount/salary")
	public void getNthHighestSalary(@RequestParam Long nthHighestSalary) {
		UserAccount nthHighestSalaryUser=userAccountService.nthHighestSalary(nthHighestSalary);
		System.out.println(nthHighestSalaryUser);
	}
	
	@GetMapping("api/v1/userAccount/highestSalary")
	public void getNthHighestSalary(@RequestParam int pageNumber,@RequestParam int pageSize) {
		List<UserAccount> nthHighestSalaryUser=userAccountService.nthHighestSalary(pageNumber,pageSize);
		System.out.println(nthHighestSalaryUser);
	}
	
	public void editUserAccountDetail(@PathVariable("userId")  Long userId,UserAccountDto userAccountDto) {
		userAccountService.editUserAccountDetail(userId,userAccountDto);
	}
}
