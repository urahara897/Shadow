package CheapCar;

import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class language {

	public WebDriver driver;
	String ActualTitle;
	String ExpectedTitle = "Demoaut.com";
	
	@BeforeTest
	public void BT() {
		
		//WebDriverManager.firefoxdriver().setup();
	    WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://ww7.demoaut.com");
	
     }
	
	@Test(priority = 1)
	public void navigate() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		ActualTitle = driver.getTitle();
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		WebElement x = driver.findElement(By.xpath("//*[@id='master-1']"));
	    driver.switchTo().frame(x);
	    driver.findElement(By.xpath("//span[text()='Cheap Car Rentals Airport']")).click();
	 
	}
	
	@Test(priority =2)
	public void navigate1() throws InterruptedException {
		
		 Thread.sleep(3000);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 ActualTitle = driver.getTitle();
		 Assert.assertEquals(ActualTitle, ExpectedTitle);
		 WebElement y = driver.findElement(By.xpath("//*[@id='master-1']"));
		 driver.switchTo().frame(y);
		 //driver.findElement(By.xpath("//*[@id=\"e4\"]/div[2]/div[1]/a/span")).click();
		 //Thread.sleep(3000);
		 //driver.findElement(By.xpath("//*[contains(text(),'Cheap Airport')]")).click();
		 driver.findElement(By.xpath("//span[text()='➤ Visit Website']")).click();
		 ArrayList<String> wid = new ArrayList<String>(driver.getWindowHandles());
	     driver.switchTo().window(wid.get(1));
		
	}
	
	@Test(priority = 4)
	public void language1() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='rch-select-language']")).click();
		ExpectedTitle = "Airport Car Hire - Rentalcars.com";
		ActualTitle = driver.getTitle();
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		//driver.findElement(By.xpath("//*[@id='rch-select-language']")).click();
		driver.findElement(By.xpath("//*[@id='366']")).click();
		
	}
	
	@AfterTest()
	public void AT() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.quit();
		
	}
		
}
