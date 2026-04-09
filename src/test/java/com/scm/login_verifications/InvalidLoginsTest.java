package com.scm.login_verifications;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.scm.baseclasses.SuperBaseClass;
import com.scm.object_repository.Login_Page_True;

public class InvalidLoginsTest extends SuperBaseClass {

	@Test
	public void invalidlAdminoginsTest() throws IOException {

		Login_Page_True lp = new Login_Page_True(driver);
		lp.invalidLogins("Ramu", "Ramu123", "Admin");
		WebElement errorMsg = lp.getErrorMsg();
		Assert.assertTrue(errorMsg.isDisplayed());
		System.out.println(errorMsg + " admin");
	}

	@Test
	public void invalidManuloginsTest() throws IOException {

		Login_Page_True lp = new Login_Page_True(driver);
		lp.invalidLogins("Shamu", "Shamu123", "Manufacturer");
		WebElement errorMsg = lp.getErrorMsg();
		Assert.assertTrue(errorMsg.isDisplayed());
		System.out.println(errorMsg + " from manufacturer");
	}

	@Test
	public void invalidRetailerloginsTest() throws IOException {

		Login_Page_True lp = new Login_Page_True(driver);
		lp.invalidLogins("tamu", "tamu123", "Retailer");
		WebElement errorMsg = lp.getErrorMsg();
		Assert.assertTrue(errorMsg.isDisplayed());
		System.out.println(errorMsg + " from retailer");
	}
}
