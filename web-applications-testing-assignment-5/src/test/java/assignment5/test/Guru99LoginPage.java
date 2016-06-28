package assignment5.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Guru99LoginPage {
	private WebDriver driver;
	
	@FindBy(name = "uid")
	private WebElement userid;
	
	@FindBy(name = "password")
	private WebElement password;
	
	@FindBy(name = "btnLogin")
	private WebElement btnLogin;
	
	private String url = "http://demo.guru99.com/v4/";
	
	public Guru99LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.get(url);
	}
	
	public void setUserId(String uid) {
		this.userid.sendKeys(uid);
	}
	
	public void setPassword(String pwd) {
		this.password.sendKeys(pwd);
	}
	
	public Guru99HomePage clickLogin() {
		this.btnLogin.click();
		return new Guru99HomePage(driver);
	}
	
	public Guru99HomePage login(String uid, String pwd) {
		this.userid.sendKeys(uid);
		this.password.sendKeys(pwd);
		this.btnLogin.click();
		return new Guru99HomePage(driver);
	}
}
