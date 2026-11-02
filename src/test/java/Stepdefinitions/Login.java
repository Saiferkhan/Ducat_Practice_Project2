package Stepdefinitions;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class Login {
	
	String   user;
	String   pass;
	WebDriver driver;
	WebDriverWait wait;
	@Before
	@Given ("User is on to login page")
	public void User_is_on_to_login_page() {
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		
	}
	@When("User enter the username and password")
	public void User_enter_the_username_and_password(DataTable data) {
		
		
		
List<Map<String, String>> table = data.asMaps(String.class, String.class);
        
       for(Map <String ,String> db:table) {
    	   
    	   user=db.get("username");
    	   pass=db.get("password");
       }
       wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys(user);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys(pass);
		
	}
	@And("Click on the login button")
	public void Click_on_the_login_button() {
		
		driver.findElement(By.tagName("button")).click();
	}
	@Then("Login successfull")
	public void Login_successfull() {
		String loginpage=driver.getCurrentUrl();
		Assert.assertEquals(loginpage, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.print("Login successfull");
	}
	@And("User should see homepage")
	public void User_should_see_homepage() {
		
	}

}
