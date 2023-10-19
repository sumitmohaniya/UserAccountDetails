package com.demo.service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClientSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.dto.UserAccountDto;
import com.demo.exceptionHandler.UserNotFoundException;
import com.demo.feign.FeignInterface;
import com.demo.model.UserAccount;
import com.demo.repository.UserAccountRepository;

@Service
public class UserAccountService {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private UserAccountRepository userAccountRepository;
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired private FeignInterface feignInterface;
	 
	
	public Object restTemplate(Long userId) {
		String url="http://localhost:8085/api/v1/users/{userId}";
		HttpHeaders headers = new HttpHeaders();
		headers.set("ContentType", "application/json");
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		HttpEntity entity=new HttpEntity(headers);
		System.out.println("user........."+userId);
		Map<String,Object> map=new HashMap<>();
		map.put("id", userId);
		return restTemplate.getForObject(url, Object.class,userId);
	}
	public UserAccount addUserAccountDetails(UserAccountDto userAccountDto) {
		// TODO Auto-generated method stub
		Object userDto=restTemplate(userAccountDto.getUserId());
		if(Objects.nonNull(userDto)) {
			boolean  accountExist=userAccountExist(userAccountDto.getUserId());
			if(!accountExist) {
				modelMapper.getConfiguration().setAmbiguityIgnored(true);
				UserAccount account=modelMapper.map(userAccountDto, UserAccount.class);
				userAccountRepository.save(account);
				return account;
			}else{
				throw new UserNotFoundException("user details already exit");
			}
		}else {
			throw new UserNotFoundException("user not found");
		}
		
	}
	
	public boolean userAccountExist(Long userId) {
		return userAccountRepository.existsByUserId(userId);
	}

	public UserAccount getUserAccountDetail(Long userId) {
			/*
			 * FeignInterface feign=Feign.builder().decoder(new
			 * GsonDecoder()).target(FeignInterface.class, "http://localhost:8085");
			 * ResponseEntity<Object> response=feign.getUserDeatils(1l);
			 */
		ResponseEntity<Object> response= feignInterface.getUserDeatils(userId); 
		
		return userAccountRepository.findById(userId)
				.orElseThrow(()-> new UserNotFoundException("user not found exception"));
	}
  
	public void editUserAccountDetail(Long userId, UserAccountDto userAccountDto) {
		// TODO Auto-generated method stub
		
	}

	public List<UserAccount> getAllUserAccountDetail() {
		// TODO Auto-generated method stub
		return userAccountRepository.findAll();
		//return null;
	}

	public UserAccount nthHighestSalary(Long nthHighestSalary) {
		List<UserAccount>	allUserAccountDetails=getAllUserAccountDetail();
		return allUserAccountDetails.stream().map(user->user).sorted(new Comparator<UserAccount>() {
			public int compare(UserAccount u1,UserAccount u2) {
				if(u1.getSalary().equals(u2.getSalary()))
					return 0;
				else if(u1.getSalary()>u2.getSalary())
					return -1;
				else
					return 1;
			}
		}).skip(nthHighestSalary).findFirst().orElse(null);
	}

	public List<UserAccount> nthHighestSalary(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		Sort sort=Sort.by("salary").descending();
		Pageable pageable=PageRequest.of(pageNumber, pageSize, sort);
		Page<UserAccount> user=userAccountRepository.findAll(pageable);
		return user.getContent();
	}

}
