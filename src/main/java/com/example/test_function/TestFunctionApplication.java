package com.example.test_function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.Assert;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
public class TestFunctionApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestFunctionApplication.class, args);
		List<String> stringList = new ArrayList<>();
		stringList.add("string 1");
		stringList.add("string 2");
		List<String> newStringList=  stringList.stream()
				.map(e -> new String("hello" + e))
				.collect(Collectors.toList());

//		System.out.println(newStringList.get(0));

//		System.out.println((new Date()).getTime());
//		System.out.println(new Date(864000));
		String user = "USER";
		System.out.println(UserRole.USER.equals(user));
	}

}
