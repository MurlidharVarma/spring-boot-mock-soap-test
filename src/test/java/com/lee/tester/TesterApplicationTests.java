package com.lee.tester;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class TesterApplicationTests {

	@Test
	@DisplayName("Testing Context Loads")
	void contextLoads() {
		assertTrue(true);
	}

}
