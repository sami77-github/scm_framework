package com.scm.login_verifications;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.scm.baseclasses.RetailersBaseClass;

public class VerifyRetailerLoginWithValidCredTest extends RetailersBaseClass {

	@Test
	public void verifyRetailerLogin() throws InterruptedException {
		
		String title = driver.getTitle();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains("Retailer"));
		Assert.assertTrue(title.contains("Retailer"));
		System.out.println("Retailer is logged in successfully");

	}
}
