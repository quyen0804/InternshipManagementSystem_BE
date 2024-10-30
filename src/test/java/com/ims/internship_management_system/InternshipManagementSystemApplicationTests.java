package com.ims.internship_management_system;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class InternshipManagementSystemApplicationTests {

	@Test
	void contextLoads() {

	}

//	static final String CURRENT_DIR = "Baeldung";
	@Test
	void whenUsingSystemProperties_thenReturnCurrentDirectory() {
		String userDirectory = System.getProperty("user.dir");
		System.out.println(userDirectory);
	}
}
