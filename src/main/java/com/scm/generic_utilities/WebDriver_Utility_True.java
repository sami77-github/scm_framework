package com.scm.generic_utilities;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriver_Utility_True {

	// Explicit wait
	public void explicitWait(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// switch driver control by Title
	public void switchControlByTitle(WebDriver driver, String expectedTitle) {
		Set<String> ids = driver.getWindowHandles();
		for (String id : ids) {
			String title = driver.switchTo().window(id).getTitle().toString();
			if (title.contains(expectedTitle)) {
				System.out.println("control transfer");
				break;
			}
		}
	}

	// switch driver control by URL
	public void switchControlByUrl(WebDriver driver, String expectedUrl) {
		Set<String> ids = driver.getWindowHandles();
		for (String id : ids) {
			String currentUrl = driver.switchTo().window(id).getCurrentUrl().toString();
			if (currentUrl.contains(expectedUrl)) {
				System.out.println("contrl transfered");
				break;
			}
		}
	}

}
