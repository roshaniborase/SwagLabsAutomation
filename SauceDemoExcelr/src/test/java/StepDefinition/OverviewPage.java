package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class OverviewPage {
	
	WebDriver driver;
	
	@Given("user done login And user is on overview page")
	public void user_done_login_and_user_is_on_overview_page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.saucedemo.com");
		
		driver.findElement(By.name("user-name")).sendKeys("standard_user");
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		driver.findElement(By.name("login-button")).click();
		
		 driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		
		driver.findElement(By.id("shopping_cart_container")).click();
		driver.findElement(By.id("checkout")).click();
		
		driver.findElement(By.id("first-name")).sendKeys("roshani");
		driver.findElement(By.id("last-name")).sendKeys("borase");
		driver.findElement(By.id("postal-code")).sendKeys("1234");
		
		driver.findElement(By.id("continue")).click();
	}

	@When("user click on cancel button")
	public void user_click_on_cancel_button() {
		driver.findElement(By.id("cancel")).click();
	}
	
	 @Then("products page is displayed")
	 public void products_page_is_displayed() throws InterruptedException {
		 String expectedText="Products";
		 String actualText=driver.findElement(By.xpath("//span[@class='title']")).getText();
		    
		 Assert.assertTrue("Process continue with invalid values", expectedText.equals(actualText));
		 Thread.sleep(3000);
		 driver.close();
	 }

	@When("user click on finish button")
	public void user_click_on_finish_button() {
		driver.findElement(By.id("finish")).click();
	}

	@Then("checkout complete page is displayed")
	public void checkout_complete_page_is_displayed() throws InterruptedException {
	    String expectedText="Thank you for your order!";
	    String actualText=driver.findElement(By.xpath("//h2[@class='complete-header']")).getText();
	    
	    Assert.assertTrue("Process continue with invalid values", expectedText.equals(actualText));
	    Thread.sleep(3000);
	    driver.close();
	}

	@When("user click on back home button")
	public void user_click_on_back_home_button() {
		driver.findElement(By.id("finish")).click();
		driver.findElement(By.id("back-to-products")).click();
	}
	


	
}
