package assignment5.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.*;

public class BankCustomerQueryStepDefs {
	private WebDriver driver;
	private Guru99CustomerQueryPage query;
	private Guru99CustomerResultPage result;
	private Guru99NavMenu menu;
	
	@Before
	public void setUp() {
		driver = new FirefoxDriver();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Given("the user has logged in with user id \"([^\"]*)\" and password \"([^\"]*)\"")
	public void theUserHasLoggedIn(String uid, String pwd) {
		System.out.println(uid + " " + pwd);
		Guru99LoginPage login = new Guru99LoginPage(driver);
		menu = (login.login(uid, pwd)).getNavMenu();
	}
	
	@And("the user is on the Edit Customer page")
	public void theUserIsOnBalanceQueryPage() {
		query = menu.clickEditCustomer();
	}
	
	@When("he submits \"([^\"]*)\" as customer id")
	public void heSubmitsAccountNo(String custid) {
		result = query.submitQuery(custid);
	}
	
	@Then("ensure the customer name is \"([^\"]*)\"")
	public void ensureCustomerName(String custname) {
		System.out.println(result.getCustomerName());
		assertEquals(custname, result.getCustomerName());
	}
	
	@And("ensure the customer gender is \"([^\"]*)\"")
	public void ensureCustomerGender(String custGender) {
		System.out.println(result.getCustomerGender());
		assertEquals(custGender, result.getCustomerGender());
	}
	
	@And("ensure the customer DoB is \"([^\"]*)\"")
	public void ensureCustomerDoB(String DoB) {
		System.out.println(result.getCustomerDoB());
		assertEquals(DoB, result.getCustomerDoB());
	}
}
