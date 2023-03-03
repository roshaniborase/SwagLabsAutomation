package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class YourInformation
{
	
	WebDriver driver;
	@Given("user done login And user is on your information page")
	public void user_done_login_and_user_is_on_your_information_page() {
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
	}

	@When("^user enters (.*) and (.*) and (.*)$")
	public void user_enters_firstName_and_lastName_and_zipcode(String firstName, String lastName, String zipcode) {
	   driver.findElement(By.id("first-name")).sendKeys(firstName);
	   driver.findElement(By.id("last-name")).sendKeys(lastName);
	   driver.findElement(By.id("postal-code")).sendKeys(zipcode);
	}
	
	@And("click on continue button")
	public void click_on_continue_button() {
	  driver.findElement(By.id("continue")).click();
	}

	@Then("next page is displayed")
	public void next_page_is_displayed() throws InterruptedException {
		String expectedText="Checkout: Overview";
	    String actualText=driver.findElement(By.xpath("//span[@class='title']")).getText();
	    
	    Assert.assertTrue("Process continue with invalid values", expectedText.equals(actualText));
	    Thread.sleep(3000);
	    driver.close();
	}

	@When("user enters (.*) and (.*) and (.*) as alphanumeric values")
	public void user_enters_firstName_and_lastName_and_zipcode_as_alphanumeric_values(String firstName, String lastName, String zipcode) {
		driver.findElement(By.id("first-name")).sendKeys(firstName);
		driver.findElement(By.id("last-name")).sendKeys(lastName);
		driver.findElement(By.id("postal-code")).sendKeys(zipcode);
	}

	@Then("message is display {string}")
	public void message_is_display(String string) throws InterruptedException {
		String expectedText="Please enter valid details.";
	    String actualText=driver.findElement(By.xpath("//span[@class='title']")).getText();
	    
	    Assert.assertTrue("Process continue with invalid values", expectedText.equals(actualText));
	    Thread.sleep(3000);
	    driver.close();
	}

	@When("user did not enter values")
	public void user_did_not_enter_values() {

	}


	@Then("display message {string}")
	public void display_message(String string) throws InterruptedException {
		String expectedText="Error: First Name is required";
	    String actualText=driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
	    
	    Assert.assertTrue("Process continue with invalid values", expectedText.equals(actualText));
	    Thread.sleep(3000);
	    driver.close();
	}
}