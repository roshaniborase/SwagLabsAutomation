package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class YourCartPage {
	WebDriver driver;
	
	@Given("user done login And user is on your cart page")
	public void user_done_login_and_user_is_on_your_cart_page(){
		
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
	}

	@When("user click on checkout")
	public void user_click_on_checkout() {
	    driver.findElement(By.id("checkout")).click();
	}

	@Then("your information page is displayed")
	public void your_information_page_is_displayed() {
		String expectedText="Checkout: Your Information";
		String actualText=driver.findElement(By.xpath("//span[@class='title'] ")).getText();
		    
		Assert.assertTrue("Page is not displayed", expectedText.equals(actualText));
		driver.close();
	}

	/*@When("user click on continue shopping")
	public void user_click_on_continue_shopping() {
		driver.findElement(By.id("continue-shopping")).click();
	}

	@Then("products page is display")
	public void products_page_is_display() {*/
		/*String expectedText="Products";
		String actualText=driver.findElement(By.xpath("//span[@class='title'] ")).getText();
		    
		Assert.assertTrue("Page is not displayed", expectedText.equals(actualText));
		driver.close();*/
		//System.out.println("");
	//}

	@When("user click on products")
	public void user_click_on_products() {
	    driver.findElement(By.xpath("//div[@class='inventory_item_name'] ")).click();
	}

	@Then("product details page is display")
	public void product_details_page_is_display() {
		driver.findElement(By.xpath("//div[@class='inventory_item_container'] ")).isDisplayed();
	}

	@When("user click on remove")
	public void user_click_on_remove() {
	   driver.findElement(By.id("remove-sauce-labs-backpack")).click();;
	  
	}

	@Then("product remove from cart")
	public void product_remove_from_cart() {
		
	}
}
