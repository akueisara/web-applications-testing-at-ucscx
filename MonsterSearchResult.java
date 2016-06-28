package edu.ucsce.webapptesting.assignment;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class MonsterSearchResult extends LoadableComponent<MonsterSearchResult> {
	private WebDriver driver;
	private String keyword, location;
	
	@FindBy(how=How.CLASS_NAME, using="js_result_row")
	private WebElement resultList;
	
	public MonsterSearchResult(WebDriver driver, String keyword, String location) {
		this.driver = driver;
		this.keyword = keyword;
		this.location = location;
		PageFactory.initElements(driver, this);
	}
	
	@Override
	protected void isLoaded() throws Error {
		assertEquals("Monster.com: " + keyword + " " + location, driver.getTitle());		
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
	}
	
	public String getJobTitle() {
		WebElement jobTitle = resultList.findElement(By.className("jobTitle"));
		return jobTitle.getText();
	}
	
	public String getCompanyName() {
		WebElement companyName = resultList.findElement(By.className("company"));
        return companyName.getText();
	}
	
	public String getLocation() {
		WebElement location = resultList.findElement(By.className("location"));
		return location.getText();
	}

}
