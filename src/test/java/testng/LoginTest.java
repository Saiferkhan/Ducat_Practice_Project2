package testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class LoginTest {
	
	WebDriver driver;
	@Test(groups="smoke",priority=0)
	//@BeforeClass
	@Parameters({"browser","url"})
	public void browserSetup(String browser , String url) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		}
		else if(browser.equalsIgnoreCase("edge")) {
			
			driver=new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(url);
		}
	}
	@Test(groups="smoke",priority=1)
	//@BeforeClass
	public void enter_Credentials() {
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
	}
	@Test(groups="regression",priority=2)
	public void clickOnLoginButoon() {
		
		String exp=driver.getCurrentUrl();
		driver.findElement(By.tagName("button")).click();
		
		String actual=driver.getCurrentUrl();
		
		//Assert.assertNotEquals(exp,actual);  //--hard assertion
		
		SoftAssert sft=new SoftAssert();  //soft assertion
		sft.assertNotEquals(exp,actual);
		
		System.out.println("Login successfully");
		
		sft.assertAll();
	}
	@Test(groups="functional",priority=3)
	//@AfterClass
	public void logout() throws InterruptedException {
		
		driver.findElement(By.xpath("//img[@class='oxd-userdropdown-img']")).click();
		Thread.sleep(3000);
		
		//driver.findElement(By.xpath("//a[text()='Logout']")).click();-----using xpath
		
		//Now using linktext
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority=4)
	//@AfterSuite
	public void tearDown() throws InterruptedException {
		
		Thread.sleep(3000);
		
		if(driver !=null) {
			driver.close();
		}
	}
}
