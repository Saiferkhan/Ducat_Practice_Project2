package testng;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataProviderRevision {
	
	FluentWait<WebDriver> wait2;
	WebDriver driver;
	WebDriverWait wait;
	@BeforeClass
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
	@Test(dataProvider="loginData")
	
	public void enter_Credentials(String username, String pass) throws InterruptedException {
		
		//-------------------fuent wait 
		
//		 wait2= new FluentWait<>(driver);
//		 wait2.pollingEvery(Duration.ofMillis(200));
//		 wait2.withTimeout(Duration.ofSeconds(20));
//		 wait2.ignoring(NoSuchElementException.class);
		
		wait =new WebDriverWait(driver,Duration.ofSeconds(20));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys(username);
	//	driver.findElement(By.name("username")).sendKeys(username);
		//driver.findElement(By.name("password")).sendKeys(pass);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys(pass);
		driver.findElement(By.tagName("button")).click();
		
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='oxd-userdropdown-img']")));
	}
	
	@DataProvider(name="loginData")
	public Object[][] getData(){
		
		return new Object [][]{
				{"admin1234","ad123"},
				{"admin321","admins"},
				{"Admin","admin123"}
		
		};
	}
	
	@AfterClass
	public void tearDown() {
		
		if(driver!=null) {
			driver.quit();
		}
	}

}
