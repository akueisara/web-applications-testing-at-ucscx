package assignment5.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Guru99NavMenu {
	private WebDriver driver;
	
	@FindBy(css = ".menusubnav > li:nth-child(3) > a")
	private WebElement editcustomer;
	
	public Guru99NavMenu(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public Guru99CustomerQueryPage clickEditCustomer() {
		this.editcustomer.click();
		return new Guru99CustomerQueryPage(driver);
	}
}
