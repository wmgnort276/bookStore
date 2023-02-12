package com.example.demo;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.Validation;
import javax.validation.Validator;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
class DemoApplicationTests {

	private static Validator validator;

	@Test
	void contextLoads() {

	}

	@BeforeClass
	public static void setupValidatorInstance(){
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}


}
