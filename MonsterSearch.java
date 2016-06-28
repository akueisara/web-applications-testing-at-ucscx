package edu.ucsce.webapptesting.assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MonsterSearch {
	private WebDriver driver;
	
	@FindBy(how=How.ID, using="doQuickSearch")
	private WebElement searchButton;
	
	@FindBy(how=How.ID, using="q1")
	private WebElement keywordInput;
	
	@FindBy(how=How.ID, using="where1")
	private WebElement locationInput;
	
	public MonsterSearch(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public MonsterSearchResult search(String keyword, String location ) {
		keywordInput.sendKeys(keyword);
		locationInput.sendKeys(location);
		searchButton.click();
		return new MonsterSearchResult(driver, keyword, location);
	}

}
