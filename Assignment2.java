package edu.ucsce.webapptesting.assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {

			WebDriver driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();

			driver.get("http://www.expedia.com/");

			WebElement FlightTab = driver.findElement(By.id("tab-flight-tab"));
			FlightTab.click();

			WebElement Origin = driver.findElement(By.id("flight-origin"));
			Origin.sendKeys("San Francisco, CA");

			WebElement Destination = driver.findElement(By.id("flight-destination"));
			Destination.sendKeys("New York, NY");

			WebElement DepartingDate = driver.findElement(By.id("flight-departing"));
			DepartingDate.sendKeys("06/20/2016");

			WebElement ReturningDate = driver.findElement(By.id("flight-returning"));
			ReturningDate.clear();
            ReturningDate.sendKeys("06/24/2016");

			WebElement Adults = driver.findElement(By.xpath("//select[@id='flight-adults']/option[@value='3']"));
			Adults.click();

			WebElement Children = driver.findElement(By.xpath("//select[@id='flight-children']/option[@value='2']"));
			Children.click();

			WebElement AgeSelect1 = driver.findElement(By.xpath("//select[@id='flight-age-select-1']/option[@value='5']"));
			AgeSelect1.click();

			WebElement AgeSelect2 = driver.findElement(By.xpath("//select[@id='flight-age-select-2']/option[@value='10']"));
			AgeSelect2.click();

			WebElement CheckCar = driver.findElement(By.xpath("//*[@id='flight-add-car-checkbox']"));
			CheckCar.click();

			WebElement SearchButton = driver.findElement(By.id("search-button"));
			SearchButton.click();

			WebElement NumberOfTraveler = driver.findElement(By.className("secondary-playback-summary"));
			System.out.println("Number of travelers: " + NumberOfTraveler.getText().substring(0,1));
			
			Thread.sleep(2000);

			driver.quit();
			
	}

}
