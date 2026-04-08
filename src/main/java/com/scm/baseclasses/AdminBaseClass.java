package com.scm.baseclasses;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.scm.object_repository.AdminHomePage;
import com.scm.object_repository.Login_Page_True;

public class AdminBaseClass extends SuperBaseClass {

	@BeforeMethod
	public void adminLogin() {
		Login_Page_True p = new Login_Page_True(driver);
		p.loginAsAdmin();
	}
	
	@AfterMethod
	public void adminLogout() {
		AdminHomePage ahp = new AdminHomePage(driver);
		ahp.getLogoutBtn().click();
	}
}
