package DemoAccount;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.Alert;
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

public class shadow2 {

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
		Assert.assertEquals(ExpectedTitle, ActualTitle);
		WebElement x = driver.findElement(By.xpath("//*[@id='master-1']"));
	    driver.switchTo().frame(x);
	    driver.findElement(By.xpath("//span[text()='Demo Account']")).click();
	 
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
		 //System.out.println(actualString);
		 driver.findElement(By.xpath("//span[text()='➤ Visit Website']")).click();
		 ArrayList<String> wid = new ArrayList<String>(driver.getWindowHandles());
	     driver.switchTo().window(wid.get(1));
		
	}
	
	@Test(priority = 3)
	public void register() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(4000);
		Assert.assertTrue(driver.getTitle().contains("Olymp Trade"));
		//ActualTitle = driver.getTitle();
		//ExpectedTitle = "Olymp Trade";
		//ExpectedTitle = "Olymp Trade — 24/7 Trading";
		//String actual = driver.findElement(By.xpath("//*[@class='text-blue']")).getText();
		//String expected = "Fixed Time";
		//Assert.assertEquals(ActualTitle, ExpectedTitle);
		driver.findElement(By.xpath("//*[@class='accept-btn']")).click();
		WebElement l=driver.findElement(By.xpath("//*[@class='forms__control forms__control--reg forms__control--active']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", l);
		driver.findElement(By.xpath("//*[@class='forms__control forms__control--reg forms__control--active']")).click();
		//driver.findElement(By.xpath("//*[@class='forms__control forms__control--log']")).click();
		driver.findElement(By.xpath("//*[@class='register-form__input register-form__email__input']")).sendKeys("demo111@gmail.com");
		driver.findElement(By.xpath("//*[@class='register-form__input register-form__password__input']")).sendKeys("Demo1234567");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='register-form__agreement-checkbox']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class='register-form__button']")).click();
		//Thread.sleep(3000);
		//Alert alert = driver.switchTo().alert();
		//String alertMessage= driver.switchTo().alert().getText(); // capture alert message

		/*System.out.println(alertMessage);
		System.out.println(alertMessage); // Print Alert Message
		Thread.sleep(5000);*/
		//alert.accept();
		//driver.switchTo().alert().accept();*/
		
	}
	
	@Test(enabled=false, priority = 4)
	public void login() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//*[@class='ButtonBase-module-host-jU9 Tab-module-host-19r']")).click();
		//driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//*[@class='InputBase-module-host-2Fs TextField-module-nativeInput-37S TextField-module-nativeInput_labeled-3TA TextField-module-nativeInput_size_medium-2UQ']")).sendKeys("demo111@gmail.com");
		driver.findElement(By.xpath("//*[@class='register-form__input register-form__password__input']")).sendKeys("Demo1234567");
		driver.findElement(By.xpath("//span[text()='Password']")).click();
		driver.findElement(By.xpath("//*[@class='ButtonBase-module-host-jU9 Button-module-host-Ejq Button-module-hostSizeLarge-369 Button-module-hostVariantContained-1XB Button-module-hostColorContainedAccent-34V Button-module-hostHasFullWidth-28i tEfwyKFr']")).click();
		
		
	}
	
	@AfterTest
	public void AT() {
		
		driver.quit();
		
	}
	
}
