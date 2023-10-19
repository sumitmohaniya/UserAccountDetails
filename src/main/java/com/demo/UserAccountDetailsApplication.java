package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class UserAccountDetailsApplication {

	public static void main(String[] args) {
		System.out.println(SpringApplication.run(UserAccountDetailsApplication.class, args).getAutowireCapableBeanFactory());
	}

}
