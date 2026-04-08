package com.scm.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {

	WebDriver driver;
	
	public AdminHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@value='Log out']")
	private WebElement logoutBtn;
	
	@FindBy(xpath = "//h1[text()='Welcome Admin']")
	private WebElement adminWelcomeMsg;

	public WebElement getAdminWelcomeMsg() {
		return adminWelcomeMsg;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}
}
