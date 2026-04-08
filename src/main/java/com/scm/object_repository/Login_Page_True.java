package com.scm.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Login_Page_True {

	WebDriver driver;

	public Login_Page_True(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "login:username")
	private WebElement userNameField;

	@FindBy(id = "login:password")
	private WebElement passwordField;

	@FindBy(id = "login:type")
	private WebElement loginType;

	@FindBy(xpath = "//option[text()='Retailer']")
	private WebElement retailer;

	@FindBy(xpath = "//option[text()='Manufacturer']")
	private WebElement manufacturer;

	@FindBy(xpath = "//option[text()='Admin']")
	private WebElement admin;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement loginBtn;

	@FindBy(xpath = "//span[text()=' * Username or Password is incorrect. ']")
	private WebElement errorMsg;

	public WebElement getErrorMsg() {
		return errorMsg;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getUserNameField() {
		return userNameField;
	}

	public WebElement getPasswordField() {
		return passwordField;
	}

	public WebElement getLoginType() {
		return loginType;
	}

	public WebElement getRetailer() {
		return retailer;
	}

	public WebElement getManufacturer() {
		return manufacturer;
	}

	public WebElement getAdmin() {
		return admin;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	// Business Logic

	public void loginAsAdmin() {
		getUserNameField().sendKeys("Admin");
		getPasswordField().sendKeys("Admin123");
		Select sel = new Select(loginType);
		sel.selectByVisibleText("Admin");
		getLoginBtn().click();
	}

	public void loginAsManufacturer() {
		getUserNameField().sendKeys("manufacturer");
		getPasswordField().sendKeys("manufacturer123");
		Select sel = new Select(loginType);
		sel.selectByVisibleText("Manufacturer");
		getLoginBtn().click();
	}

	public void loginAsRetailer() {
		getUserNameField().sendKeys("retailer");
		getPasswordField().sendKeys("retailer123");
		Select sel = new Select(loginType);
		sel.selectByVisibleText("Retailer");
		getLoginBtn().click();
	}
}
