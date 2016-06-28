package assignment5.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Guru99CustomerResultPage {
	private WebDriver driver;
	
	@FindBy(xpath = "//input[@name='name']")
	private WebElement customerName;
	
	@FindBy(xpath = "//*[@name='gender']")
	private WebElement customerGender;
	
	@FindBy(xpath = "//*[@name='dob']")
	private WebElement customerDoB;
	
	private String url = "http://demo.guru99.com/v4/manager/EditCustomer.php";
	
	public Guru99CustomerResultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		//driver.get(url);
	}
	
	public String getCustomerName() {
		return customerName.getAttribute("value");
	}
	public String getCustomerGender() {
		return customerGender.getAttribute("value");
	}
	public String getCustomerDoB() {
		return customerDoB.getAttribute("value");
	}
}
