package edu.ucsce.webapptesting.assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import static org.junit.Assert.*;

public class MonsterHomePage extends LoadableComponent<MonsterHomePage> {
	private WebDriver driver;
	
	private String url = "http://www.monster.com/";
	private String title = "Monster Jobs";
	
	public MonsterHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@Override
	protected void isLoaded() throws Error {
		assertTrue("Monster home page cannot be loaded", driver.getTitle().startsWith(title));
	}

	@Override
	protected void load() {
		driver.get(url);
	}
	
	public MonsterSearch getSearch() {
		return new MonsterSearch(driver);
	}
}
