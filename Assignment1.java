package edu.ucsce.webapptesting.assignment;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./src/drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver(); // Create a WebDriver instance ¡X open a browser
        // WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();

		driver.get("http://www.amazon.com/"); // Connect to amazon.com

		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox")); // Find the search box - using inspect

		// Enter search keyword
		searchBox.clear();
		searchBox.sendKeys("Selenium WebDriver");

		// Find the search icon/button - Using Inspect and Copy XPath
		WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input"));
		searchButton.click(); // Click the search button

		//WebElement result_count = driver.findElement(By.id("s-result-count")); 
		//System.out.println("Number of books listed in this page: " + result_count.getText().substring(2, 4) + '\n'); // Print the search result

		List<WebElement> book_details = driver.findElements(By.xpath("//div[@class='s-item-container']//h2 | //a/h3[@data-attribute='Paperback'] | //span[contains(text(),'$')]"));

		List<Integer> index =  new ArrayList<Integer>();
		for(int i=0;i<book_details.size();i++){
			if (book_details.get(i).getTagName().equals("h2")){
			    index.add(i);
			}
		}
		
		System.out.println("Number of books listed in this page: " + index.size() + '\n'); // Print the search result
		
		boolean flag = false; 
		int j = 0;
		for(int i=0;i<book_details.size();i++){
			if (index.get(j) == i){
				
				System.out.println(book_details.get(i).getText());
				
				if(j+1<index.size()){
					for(int k=i+1;k<index.get(j+1);k++){
						if(book_details.get(k).getTagName().equals("h3")){
							System.out.println(book_details.get(k+1).getText()+'\n');
							flag = true;
						}
					}
				}
				else{
					for(int k=i+1;k<book_details.size();k++){
						if(book_details.get(k).getTagName().equals("h3")){
							System.out.println(book_details.get(k+1).getText()+'\n');
							flag = true;
						}
					}
				}
				
				if (!flag)
					System.out.println("No Paperback price\n");
				
				flag = false;
				
				if (j+1<index.size()){
					i = index.get(j+1)-1;
					j++;
				}
			}
		}

		Thread.sleep(2000);

		driver.quit(); // Close the browser
	}
}
