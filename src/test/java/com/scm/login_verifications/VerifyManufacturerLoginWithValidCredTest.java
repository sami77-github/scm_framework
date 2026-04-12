package com.scm.login_verifications;

import org.jspecify.annotations.Nullable;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.scm.baseclasses.ManufacturerBaseClass;

public class VerifyManufacturerLoginWithValidCredTest extends ManufacturerBaseClass {

	@Test
	public void verifyManuLogin() throws InterruptedException {
		@Nullable
		String title = driver.getTitle();
		Thread.sleep(1000);
		Assert.assertTrue(title.contains("Manufacturer"));
		System.out.println("manufacturer is successfully logged in");
	}
}
