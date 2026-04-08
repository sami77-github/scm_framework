package com.scm.baseclasses;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.scm.object_repository.Login_Page_True;
import com.scm.object_repository.ManufacturerHomepage;

public class ManufacturerBaseClass extends SuperBaseClass {

	@BeforeMethod
	public void manufacturerLogin() {
		Login_Page_True p = new Login_Page_True(driver);
		p.loginAsManufacturer();
	}
	
	@AfterMethod
	public void manufacturerLogout() {
		ManufacturerHomepage mhp = new ManufacturerHomepage(driver);
		mhp.getLogoutBtn().click();
	}
}
