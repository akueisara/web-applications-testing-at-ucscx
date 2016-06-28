package edu.ucsce.webapptesting.assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.get("http://www.expedia.com/");
		try {
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

			WebElement display = driver.findElement(By.xpath("//*[@id='acol-interstitial']"));
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver d) {	
					return !display.isDisplayed();
				}});

			List<WebElement> FlightList = driver.findElements(By.xpath("//*[@class='segment-info info cf target toggle-trigger flight-module prevent-flicker']"));

			for (WebElement flight: FlightList){

				WebElement DepartureTime = flight.findElement(By.xpath(".//*[@class='departure-time departure-emphasis']"));
				WebElement ArrivalTime = flight.findElement(By.xpath(".//*[@class='arrival-time arrival-emphasis']"));
				System.out.println("Departure time: " + DepartureTime.getText());
				System.out.print("Arrival time: " + ArrivalTime.getText());

				WebElement testnextday = flight.findElement(By.className("primary"));
				if (testnextday.getText().contains("+1")){
					System.out.println(" (next day)");
				}
				else
				{
					System.out.println();
				}
				WebElement DollarPrice = flight.findElement(By.xpath(".//*[@class='dollars price-emphasis']"));
				WebElement CentPrice = flight.findElement(By.xpath(".//*[@class='cents secondary price-emphasis']"));
				System.out.println("Price: " + DollarPrice.getText() + CentPrice.getText() + "\n");
			}

			Thread.sleep(2000);

		} finally {
			driver.quit();
		}
	}
}
