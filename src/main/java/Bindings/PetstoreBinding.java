package Bindings;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PetstoreBinding {
	
	public static String url = "https://jpetstore.aspectran.com/catalog/";
	public static WebDriver driver;
	public static Actions action;
	public static WebDriverWait wait;

	
	//Locators
	public static By forsigninpage = By.linkText("Sign In");
	public static By forusername = By.name("username");
	public static By forpassword = By.name("password");
	public static By forloginbttn = By.xpath("//button[text()='Login']");
	public static By foraddtocart = By.linkText("Add to Cart");
	public static By forcheckout = By.linkText("Proceed to Checkout");
	public static By forordercontinue = By.xpath("//button[@type='submit' and text()='Continue']");
	public static By fororderconfirm = By.xpath("//button[@type='submit' and text()='Confirm']");
	public static By formyorder = By.linkText("My Orders");
	
	
	@Given("I open Sign in page")
	public void i_open_sign_in_page() {
	    
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		action = new Actions(driver);
	    driver.get(url);
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    wait = new WebDriverWait(driver,Duration.ofSeconds(60));
	    
	    driver.findElement(forsigninpage).click();
	    
	}

	@When("I enter username {string} and password {string}")
	public void i_enter_username_and_password(String string, String string2) {
	    
		WebElement username = driver.findElement(forusername);
		action
		.doubleClick(username)
		.build().perform();
		
		username.sendKeys(string);
		
		WebElement password = driver.findElement(forpassword);
		
		action
		.doubleClick(password)
		.build().perform();
		
		password.sendKeys(string2);
	    
	}

	@And("I click on login button")
	public void i_click_on_login_button() {
	    
		driver.findElement(forloginbttn).click();
	    
	}

	@Then("I navigate to welcome page")
	public void i_navigate_to_welcome_page() {
	    
		assertTrue(driver.findElement(By.linkText("My Account")).isDisplayed());
	    
	}
	
	
	
	@Given("I am on welcome page")
	public void i_am_on_welcome_page() {
	    
		assertTrue(driver.findElement(By.linkText("My Account")).isDisplayed());
	    
	}

	@When("I choose a particular type of pet")
	public void i_choose_a_particular_type_of_pet(DataTable dataTable) {
	    
		List<List<String>> input = dataTable.asLists(String.class);
		
		driver.findElement(By.linkText(input.get(0).get(0))).click();;
		driver.findElement(By.linkText(input.get(0).get(1))).click();;
		driver.findElement(By.linkText(input.get(0).get(2))).click();;
	    
	}

	@When("I click on add to cart")
	public void i_click_on_add_to_cart() {
	    
	    driver.findElement(foraddtocart).click();
	    
	}

	@When("I click on proceed to checkout")
	public void i_click_on_proceed_to_checkout() {
	    
		driver.findElement(forcheckout).click();
		driver.findElement(forordercontinue).click();
	    
	}

	@When("I confirm the order")
	public void i_confirm_the_order() {
	    
		driver.findElement(fororderconfirm).click();
		
	}

	@Then("I verify the order submission in MyOrder section")
	public void i_verify_the_order_submission_in_my_order_section() {
	    
		String orderid = driver.findElement(By.xpath("//table[1]/tbody[1]/tr[1]/td[2]")).getText();
		
		driver.findElement(formyorder).click();
		
		String inmyorders = driver.findElement(By.xpath("//table[1]/tbody[1]/tr[2]/td[1]")).getText();
		
		assertEquals(orderid.split("#")[1], inmyorders);
		
	    
	}



}
