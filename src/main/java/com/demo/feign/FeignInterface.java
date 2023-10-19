package com.demo.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value="user-application",url="http://localhost:8085")
public interface FeignInterface {

	
	 //@RequestLine("GET /api/v1/users/{id}")
	 //@Headers("Content-Type: application/json")
	@GetMapping("/api/v1/users/{id}")
	ResponseEntity<Object> getUserDeatils(@PathVariable("id") Long id);

	
}
