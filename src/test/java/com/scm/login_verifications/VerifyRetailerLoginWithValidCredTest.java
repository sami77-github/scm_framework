package com.scm.login_verifications;

import org.jspecify.annotations.Nullable;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.scm.baseclasses.RetailersBaseClass;

public class VerifyRetailerLoginWithValidCredTest extends RetailersBaseClass {

	@Test
	public void verifyRetailerLogin() {
		
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Retailer"));
		System.out.println("Retailer is logged in successfully");
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("retailer"));
		System.out.println("Retailer is logged in successfully");
	}
}
