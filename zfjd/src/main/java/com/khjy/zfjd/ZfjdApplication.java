package com.khjy.zfjd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
// @EnableCaching
public class ZfjdApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZfjdApplication.class, args);
	}

}
