package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.base.BaseClass;

public class LoginPage extends BaseClass {

	WebDriver driver = null;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory .initElements(driver, this);	
	}
	
	
	@FindBy(xpath = "//input[@id='email' and @type='text']")
	private WebElement enterUserName;

	@FindBy(xpath = "//input[@id='password' and @type='password']")
	private WebElement enterPassword;

	@FindBy(xpath = "//button[text()='Sign In' and @type='submit']")
	private WebElement signInButton;
	
	
	public boolean checkLoginCredential(String uname, String pass) throws Exception{
		enterUserName.clear();
		enterUserName.sendKeys(uname);
		
		enterPassword.clear();
		enterPassword.sendKeys(pass);
		
		signInButton.click();
		
		  if(driver.getTitle().equals("JavaByKiran | Dashboard")) {
			  
			driver.navigate().back();

			return true;
		
		}else {
			
			return false;
		}
	}
}

