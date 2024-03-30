package com.Spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootApplication {

	public static void main(String[] args) {

		var ctx = SpringApplication.run(BootApplication.class, args);
//		MyFirstClass myFirstClass=ctx.getBean(MyFirstClass.class);
//		System.out.println(myFirstClass.sayhello());
		MyFirstService myFirstService=ctx.getBean(MyFirstService.class);
		System.out.println(myFirstService.tellStory());
	}
}
