package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class AddToCart {
	
WebDriver driver;

	@Given("browser is open And user done login")
	public void browser_is_open_and_user_done_login() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com");
		
		driver.findElement(By.name("user-name")).sendKeys("standard_user");
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		driver.findElement(By.name("login-button")).click();
	}

	@When("user clicks on add to cart")
	public void user_clicks_on_add_to_cart() throws InterruptedException {
	    driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
	    driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
	    Thread.sleep(3000);
	}

	@Then("products add to the cart")
	public void products_add_to_the_cart() {
	   System.out.println("Product added to the cart");
	   driver.close();
	}

	@And("user clicks on remove")
	public void user_clicks_on_remove() throws InterruptedException {
		 driver.findElement(By.id("remove-sauce-labs-backpack")).click();
		 Thread.sleep(3000);
	}

	@Then("products remove from cart")
	public void products_remove_from_cart() {
	   System.out.println("Product remove from cart");
	   driver.close();
	}
	
	@Then("count of cart incresed")
	public void count_of_cart_incresed() {
	  String count = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText();
	  System.out.println("Count of cart increased by " + count);
	  driver.close();
	}

	@Then("count of cart decreased")
	public void count_of_cart_decreased() {
		String count = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText();
    	System.out.println("Count of cart decreased by " + count);
    	driver.close();
	}
	
	@When("user clicks on add to cart button")
	public void user_clicks_on_add_to_cart_button() throws InterruptedException {
	    driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
	    Thread.sleep(2000);
	}

	@Then("user is on your cart page")
	public void user_is_on_your_cart_page() {
		String expectedText="Your Cart";
	    String actualText=driver.findElement(By.xpath("//span[@class='title']")).getText();
	    
	    Assert.assertTrue("User is not on ' your cart page '", expectedText.equals(actualText));
	      
	    driver.close();
		
	}


}
