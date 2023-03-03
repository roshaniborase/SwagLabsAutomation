package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class LoginSD {
WebDriver driver;
	
	@Given("browser is open")
	public void browser_is_open() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/");
	}

	@When("^user enters valid (.*) and (.*)$")
	public void user_enters_valid_username_and_password(String username,String password) {
	   WebElement username1 =driver.findElement(By.name("user-name"));
	   username1.clear();
	   username1.sendKeys(username);
	   WebElement pass1=driver.findElement(By.name("password"));
	   pass1.clear();
	   pass1.sendKeys(password);
	  
	}

	@And("clicks on login button")
	public void clicks_on_login_button() {
	    driver.findElement(By.name("login-button")).click();
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() throws InterruptedException {
		String expectedText="Swag Labs";
	    String actualText=driver.findElement(By.xpath("//div[@class='app_logo']")).getText();
	    
	    Assert.assertTrue("Log in not successful", expectedText.equals(actualText));
	    Thread.sleep(3000);
	    driver.close();
	}
	
	@When("^user enters invalid (.*) and (.*)$")
	public void user_enters_invalid_username_and_password(String username,String password) {
	   driver.findElement(By.name("user-name")).sendKeys(username);
	   driver.findElement(By.name("password")).sendKeys(password);
	}
	
	@Then("user get a message {string}")
	public void user_get_a_message(String string) throws InterruptedException {
		 if(driver.getTitle().contains("Epic sadface")) {
			   System.out.println("User can't login using invalid credentials");
		   }
		   Thread.sleep(3000);
		   driver.close();
	}
		
}
