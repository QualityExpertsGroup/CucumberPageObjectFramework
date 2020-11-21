package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import util.BaseTest;

public class LoginPage extends BaseTest {
	
	public LoginPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText="Sign in")
    WebElement btnSignin; 
	
	@FindBy(id="email")
    WebElement txtEmail; 
	
	@FindBy(id="passwd")
    WebElement txtPwd; 
	
	@FindBy(id="SubmitLogin")
    WebElement btnLogin;
	
	@FindBy(xpath=".//a[@class='account']/span")
    WebElement lblUserName;
	
	@FindBy(className="page-heading")
    WebElement lblPageHeading;
	
	@FindBy(linkText="Sign out")
    WebElement btnSignOut;
	
	
	public void clickSingin() {
		btnSignin.click();
	}
	
	public void enterUsername(String email) {
		waitUntilClickable(txtEmail);
		txtEmail.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		txtPwd.sendKeys(password);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public void clickLogOut() {
		btnSignOut.click();
	}
	public void validateLogin() {
		if(lblUserName.isDisplayed()) {
			String name = lblUserName.getText();
			Assert.assertEquals(name, "sample test");
		}
	}
	
	public void validateLogOut() {
		if(btnSignOut.isDisplayed()) {
			btnSignOut.click();
			String text = lblPageHeading.getText();
			Assert.assertEquals(text,"AUTHENTICATION");
		}
	}
	
}
