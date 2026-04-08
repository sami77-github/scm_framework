package com.scm.baseclasses;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.scm.object_repository.Login_Page_True;
import com.scm.object_repository.RetailersHomePage;

public class RetailersBaseClass extends SuperBaseClass {

	@BeforeMethod
	public void retailerLogin() {
		Login_Page_True lp = new Login_Page_True(driver);
		lp.loginAsRetailer();
	}
	
	@AfterMethod
	public void retailerLogout() {
		RetailersHomePage rhp = new RetailersHomePage(driver);
		rhp.getLogoutBtn().click();
	}
}
