package com.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.LoginPage;
import com.utility.ExcelSheetUtils;
import com.utility.ExcelSheetWriteUtils;

public class LoginPageTest extends BaseClass {

	LoginPage loginpage = null;

	ExcelSheetWriteUtils data = new ExcelSheetWriteUtils();

	@BeforeClass
	public void setUp() throws Exception {
		driver = Initialization();
		loginpage = loadLoginPage();
	}

	int i = 0;

	@Test(dataProvider = "sendData")
	public void verify_Login_Scenario(String username, String password) throws Exception {

		if (i == 0) {
			data.excelSheetWrite("OfflineWebSiteData.xlsx", "logindata", i, 2, "Result");

			i++;
		}

		boolean value = loginpage.checkLoginCredential(username, password);

		System.out.println(value);

		if (value == true) {

			data.excelSheetWrite("OfflineWebSiteData.xlsx", "logindata", i, 2, "Pass");

			i++;

			Assert.assertTrue(true);

		} else if (value == false) {

			data.excelSheetWrite("OfflineWebSiteData.xlsx", "logindata", i, 2, "Fail");

			i++;

			Assert.assertTrue(false);
		}
		i++;
	}

	@DataProvider
	public Object[][] sendData() throws Exception {

		ExcelSheetUtils utils = new ExcelSheetUtils();

		return utils.readExcelSheet();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
