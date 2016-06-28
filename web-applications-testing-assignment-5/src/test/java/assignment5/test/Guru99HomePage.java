package assignment5.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Guru99HomePage {
	private WebDriver driver;
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[3]/td")
	private WebElement managerId;
	
	private String url = "http://demo.guru99.com/v4/manager/Managerhomepage.php";
	
	public Guru99HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//driver.get(url);
	}
	
	public String getManagerId() {
		return managerId.getText();
	}
	
	public Guru99NavMenu getNavMenu() {
		return new Guru99NavMenu(driver);
	}
}
