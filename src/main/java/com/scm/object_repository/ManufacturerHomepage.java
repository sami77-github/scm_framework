package com.scm.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManufacturerHomepage {

	WebDriver driver;

	public ManufacturerHomepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@value='Log out']")
	private WebElement logoutBtn;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}
}
