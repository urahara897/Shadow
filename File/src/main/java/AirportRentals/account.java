package AirportRentals;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class account {

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
	public void create_account() throws InterruptedException{
		
		ArrayList<String> wid = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(wid.get(1));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String expected = "Sign Up";
		driver.findElement(By.xpath("//*[@id='onetrust-accept-btn-handler']")).click();
		driver.findElement(By.xpath("//*[@id=\"rch-select-sign-in\"]/i")).click();
		driver.findElement(By.id("createAccountModalOpen")).click();
		//driver.findElement(By.xpath("//span[text()='Create an account']")).click();
		driver.findElement(By.xpath("//*[@placeholder='Enter Email address']")).sendKeys("demo@gmail.com");
		driver.findElement(By.xpath("//*[@placeholder='Enter Password']")).sendKeys("Demo1234567");
		String actual = driver.findElement(By.xpath("//*[@class='rc-btn lg bg-green-1 txt-white loyaltyCompSignIn']")).getText();
		Assert.assertEquals(actual, expected);
		driver.findElement(By.xpath("//*[@class='rc-btn lg bg-green-1 txt-white loyaltyCompSignIn']")).click();
		driver.findElement(By.xpath("//*[@class='a11y-normalise-button modal_promo_close']")).click();
		
		
	}
	
	@Test(priority = 4)
	public void signin() {

    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    String expected = "Forgotten your password?";
    driver.findElement(By.xpath("//*[@id=\"rch-select-sign-in\"]/i")).click();
	driver.findElement(By.xpath("//*[@name='crmEmail']")).sendKeys("demo@gmail.com");	
	driver.findElement(By.xpath("//*[@name='crmPsw']")).sendKeys("Demo1234567");
	String actual = driver.findElement(By.xpath("//*[@id='forgotCRMpassword']")).getText();
	Assert.assertEquals(actual, expected);
	driver.findElement(By.xpath("//*[@id='crmLogin']")).click();
		
	}
	
	 @AfterTest()
	    public void AT() throws InterruptedException {
	    	
	    	Thread.sleep(5000);
	    	driver.quit();
	
	
}
}
