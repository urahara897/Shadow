package AirportRentals;
import java.awt.AWTException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class shadow {

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
			//driver.navigate().to("https://www.rentalcars.com/us/airport-rentals");
			
		}
		
		@Test(priority = 1)
		public void navigate() throws AWTException, InterruptedException {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			//Assertion
			ActualTitle = driver.getTitle();
			Assert.assertEquals(ExpectedTitle, ActualTitle);
			WebElement x = driver.findElement(By.xpath("//*[@id='master-1']"));
		    driver.switchTo().frame(x);
			//Actions act = new Actions(driver);
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		    driver.findElement(By.xpath("//span[text()='Airport Rentals']")).click();
		}
		
		@Test(priority =2)
		public void navigate1() {
			String expectedString;
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			//js.executeScript("arguments[0].scrollIntoView()", Element);
		    WebDriverWait wait = new WebDriverWait (driver, 20);
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='master-1']")));
		    WebElement y = driver.findElement(By.xpath("//*[@id='master-1']"));
		    driver.switchTo().frame(y);
		    //Assertion
		    String actualString = driver.findElement(By.xpath("//span[text()='Rental']")).getText();
		    //System.out.println(actualString);
		    expectedString = "RENTAL";
			Assert.assertEquals(actualString, expectedString);
		    driver.findElement(By.xpath("//span[text()='➤ Visit Website']")).click();
			
		}
		
		
		
		
		@Test(priority = 3)
		public void book() throws InterruptedException
		{
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			ActualTitle = driver.getTitle();
			//Assertion
			Assert.assertEquals(ExpectedTitle, ActualTitle);
			ArrayList<String> wid = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(wid.get(1));
			driver.findElement(By.xpath("//*[@id='onetrust-accept-btn-handler']")).click();
			//WebElement z = driver.findElement(By.xpath("//*[@name='SearchResultsForm']"));
			//driver.switchTo().frame(z);
			driver.findElement(By.xpath("//*[@id='pu-country']")).click();
			//Thread.sleep(3000);
			//WebElement wb = driver.findElement(By.xpath("//*[contains(text(), 'India')]"));
			Thread.sleep(3000);
			Select country = new Select(driver.findElement(By.id("pu-country")));
			country.selectByVisibleText("India");
			Select city = new Select(driver.findElement(By.id("pu-city")));
			city.selectByVisibleText("Bangalore");
			Select location = new Select(driver.findElement(By.id("pu-location")));
			location.selectByVisibleText("Bangalore International Airport");
			WebElement element = driver.findElement(By.xpath("//*[@id='formsubmit']"));
			//JavascriptExecutor executor = (JavascriptExecutor)driver;
			//executor.executeScript("arguments[0].click();",element);
			Actions actions = new Actions(driver);
			actions.moveToElement(element);
			actions.perform();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id='formsubmit']")).click();
		}
		
	    @Test(enabled = false,priority = 4)
	    //can't access this page anymore cuz site is thinking I am a bot
	    public void show_cars() throws InterruptedException {
	    	
	    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    	
	    	if(driver.findElement(By.xpath("//*[contains(text(),'Pardon Our Interruption')]"))!= null) {
	    		
	    		driver.findElement(By.xpath("//*[@class='recaptcha-checkbox-border']")).click();
	    		
	    	}
	    	Thread.sleep(5000);
	    	driver.findElement(By.xpath("//*[@id='show-cars-link']")).click();
	    	Thread.sleep(5000);
	    	driver.findElement(By.xpath("//*[@id='show-cars-link']")).click();
	    	
	    }
	    
	    @AfterTest()
	    public void AT() throws InterruptedException {
	    	
	    	Thread.sleep(5000);
	    	driver.quit();
	    	
	    }
			
		}
		

