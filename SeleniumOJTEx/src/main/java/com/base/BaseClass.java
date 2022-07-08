package com.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.pages.LoginPage;

public class BaseClass {
	public static WebDriver driver = null;
	public Properties prop = null;

	public WebDriver Initialization() throws Exception {

		FileInputStream fis = new FileInputStream("C:\\Users\\rajen\\eclipse-workspace 21\\SeleniumOJTEx\\src\\main\\resources\\configue.properties");
		prop = new Properties();
		prop.load(fis);
		String browser = prop.getProperty("browser");

		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		} else 
		if (browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver = new FirefoxDriver();
		}
		setBrowser();
		return driver;
	}

	public void setBrowser() {
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public LoginPage loadLoginPage() {
		LoginPage loginpage= new LoginPage(driver);
		return loginpage;
	}
}
