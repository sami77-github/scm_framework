package com.scm.login_verifications;

import org.jspecify.annotations.Nullable;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.scm.baseclasses.ManufacturerBaseClass;

public class VerifyManufacturerLoginWithValidCredTest extends ManufacturerBaseClass {

	@Test
	public void verifyManuLogin() {
		@Nullable
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("manufacturer"));
		System.out.println("manufacturer is successfully logged in");
	}
}
