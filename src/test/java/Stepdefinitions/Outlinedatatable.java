package Stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class Outlinedatatable {
	
	WebDriver driver;
	WebDriverWait wait;
	@Before
    public void setUp() {
		 driver = new ChromeDriver();
        driver.manage().window().maximize();

       
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
	 
    @Given("user go to the login page")
    public void user_go_to_the_login_page() {
    	
    	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    	
    }

    @When("Enter the login data {string} and {string}")
    public void enter_the_login_data(String username, String password) {
    	
    	 wait=new WebDriverWait(driver,Duration.ofSeconds(20));
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys(username);
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys(password);

    }

    @And("press the enter button")
    public void press_the_enter_button() {
    	
    	driver.findElement(By.tagName("button")).click();

    }

    @Then("login successfull with correct data")
    public void login_successfull_with_correct_data() {
    	
    	SoftAssert soft =new SoftAssert();
    	
    }

    @And("user get error with incorrect data")
    public void user_get_error_with_incorrect_data() {

    }
	 

}
