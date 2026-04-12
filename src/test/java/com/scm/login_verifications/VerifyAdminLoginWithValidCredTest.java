package com.scm.login_verifications;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.scm.baseclasses.AdminBaseClass;

public class VerifyAdminLoginWithValidCredTest extends AdminBaseClass{

	@Test
	public void verifyAdminLogin() throws InterruptedException {
		
		String title = driver.getTitle();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains("Admin"));
		Assert.assertTrue(title.contains("Admin"));
		System.out.println(title+" is Displayed Admin Login successfully");
	}
}
