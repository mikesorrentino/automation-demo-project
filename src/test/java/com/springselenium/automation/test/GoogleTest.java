package com.springselenium.automation.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.springselenium.automation.AutomationApplicationTests;
import com.springselenium.automation.pages.google.GooglePage;

public class GoogleTest extends AutomationApplicationTests {

	@Autowired
	private GooglePage googlePage;
	
	@Test
	public void googleTest() {
		googlePage.goTo();
		assertTrue(googlePage.isAt());
	}
}
