package com.jenkinstest.jenkinstest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class JenkinstestApplicationTests {

	@Test
	void contextLoads() {
		TestController homeController = new TestController();
		String result = homeController.getHelloWorld();
		assertEquals(result, "Helloooo Andy.. How are you doing today???");
	}

	@Test
	void testHello() {
		TestController homeController = new TestController();
		String result = homeController.getHelloWorld();
		assertEquals(result, "Helloooo Andy.. How are you doing today???");
	}

}
