package assignment5.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Guru99CustomerQueryPage {
	private WebDriver driver;
	
	@FindBy(name = "cusid")
	private WebElement customerid;
	
	@FindBy(name = "AccSubmit")
	private WebElement btnSubmit;
	
	private String url = "http://demo.guru99.com/v4/manager/EditCustomer.php";
	
	public Guru99CustomerQueryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//driver.get(url);
	}
	
	public Guru99CustomerResultPage submitQuery(String customerID) {
		customerid.sendKeys(customerID);
		btnSubmit.click();
		return new Guru99CustomerResultPage(driver);
	}
}
