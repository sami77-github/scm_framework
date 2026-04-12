package com.scm.login_verifications;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.scm.baseclasses.AdminBaseClass;

public class VerifyAdminLoginWithValidCredTest extends AdminBaseClass{

	@Test
	public void verifyAdminLogin() throws InterruptedException {
		
		String title = driver.getTitle();
		Thread.sleep(1000);
		Assert.assertTrue(title.contains("Admin"));
		System.out.println(title+" is Displayed Admin Login successfully");
	}
}
