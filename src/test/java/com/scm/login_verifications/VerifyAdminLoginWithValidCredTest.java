package com.scm.login_verifications;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.scm.baseclasses.AdminBaseClass;
import com.scm.object_repository.AdminHomePage;

public class VerifyAdminLoginWithValidCredTest extends AdminBaseClass{

	@Test
	public void verifyAdminLogin() {
		
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Admin"));
		System.out.println(title+" is Displayed Admin Login successfully");
	}
}
