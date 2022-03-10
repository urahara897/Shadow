package Privacy;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Policy {

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
		//System.out.println(driver.getTitle());
		ActualTitle = driver.getTitle();
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		WebElement x = driver.findElement(By.xpath("//*[contains(text(), 'Privacy Policy')]"));
	    x.click();
	    ArrayList<String> wid = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(wid.get(1));
	    //driver.findElement(By.xpath("//span[text()='Cheap Car Rentals Airport']")).click();
	    driver.findElement(By.xpath("//*[contains(text(), 'http://www.networkadvertising')]")).click();
	    wid = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(wid.get(2));
		ActualTitle = driver.getTitle();
		ExpectedTitle = "Opt Out - NAI: Network Advertising Initiative";
		Assert.assertEquals(ExpectedTitle, ActualTitle);
		WebElement l=driver.findElement(By.xpath("//*[contains(text(), 'Opt Out Browser Check')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", l);
		driver.findElement(By.xpath("//*[contains(text(), 'Opt Out Browser Check')]")).click();
		
	}
	
	@Test(priority = 2)
	public void opt() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//*[@class='main-view__option-button']")).click();
		ActualTitle = driver.getTitle();
		ExpectedTitle = "NAI Consumer Opt Out";
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		Thread.sleep(30000);
		
		
	}
	
	@AfterTest
	public void AT() {
		
		driver.quit();
	}
}
