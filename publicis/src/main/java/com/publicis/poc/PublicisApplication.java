package com.publicis.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class PublicisApplication {

	public static void main(String[] args) {
		SpringApplication.run(PublicisApplication.class, args);
	}

}
