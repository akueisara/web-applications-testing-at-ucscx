package edu.ucsce.webapptesting.assignment;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MonsterSearchTest {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void testBookSearch() {
		MonsterHomePage home = new MonsterHomePage(driver);
		home.get();
		MonsterSearchResult result = home.getSearch().search("selenium","San Jose");
		assertEquals("Senior QA Engineer - Selenium - Python", result.getJobTitle());
		assertEquals("CyberCoders", result.getCompanyName());
		assertEquals("Menlo Park ,CA", result.getLocation());
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
