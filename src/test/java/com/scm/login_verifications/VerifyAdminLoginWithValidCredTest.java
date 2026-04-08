package com.scm.login_verifications;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.scm.baseclasses.AdminBaseClass;
import com.scm.object_repository.AdminHomePage;

public class VerifyAdminLoginWithValidCredTest extends AdminBaseClass{

	@Test
	public void verifyAdminLogin() {
		AdminHomePage ahp = new AdminHomePage(driver);
		WebElement adminWCMsg = ahp.getAdminWelcomeMsg();
		Assert.assertTrue(adminWCMsg.isDisplayed());
		System.out.println(adminWCMsg+" is Displayed Admin Login successfully");
	}
}
