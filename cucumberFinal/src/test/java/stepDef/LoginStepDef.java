package stepDef;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import util.BaseTest;

public class LoginStepDef extends BaseTest{
	
	LoginPage loginPage;
	
	public LoginStepDef() throws IOException {
		super();
	}
	
	@Before
	public void setUp() {
		initialization();
	}
	
	@Given("User landed on the homepage of AUT")
	public void user_landed_on_the_homepage_of_aut() {
		System.out.println("inside step def");
		driver.get(prop.getProperty("url"));
		Assert.assertEquals(driver.getTitle(), "My Store");
	}

	@When("User enters the credentials {string} and {string}")
	public void user_enters_the_credentials_and(String email, String password) throws IOException {
		loginPage = new LoginPage();
		loginPage.clickSingin();
		loginPage.enterUsername(email);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
	}

	@Then("User should be logged in successfully")
	public void user_should_be_logged_in_successfully() {
		loginPage.validateLogin();
		loginPage.validateLogOut();
	}

	@Then("User should see the error message")
	public void user_should_see_the_error_message() {
		 System.out.println("Error message ll be displayed");
	}
	@After
	public void tearDown() {
		closure();
	}
}
