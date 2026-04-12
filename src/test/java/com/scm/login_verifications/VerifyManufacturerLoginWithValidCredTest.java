package com.scm.login_verifications;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.scm.baseclasses.ManufacturerBaseClass;

public class VerifyManufacturerLoginWithValidCredTest extends ManufacturerBaseClass {

	@Test
	public void verifyManuLogin() throws InterruptedException {
		@Nullable
		String title = driver.getTitle();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.titleContains("Manufacturer"));
		Thread.sleep(3000);
		Assert.assertTrue(title.contains("Manufacturer"));
		System.out.println("manufacturer is successfully logged in");
	}
}
