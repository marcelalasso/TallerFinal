package com.globant.web.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Parent of the other classes of pages.
 * @author juan.montes
 */
public class BasePage {
	
	protected WebDriver driver;
	private static WebDriverWait wait;
	public static Logger log = Logger.getLogger(BasePage.class);
	
	/**
	 * Constructor.
	 * @param pDriver : WebDriver
	 */
	public BasePage (WebDriver pDriver) {
		PageFactory.initElements(pDriver, this);
		wait = new WebDriverWait(pDriver, 30);
		driver = pDriver;
	}
	
	/**
	 * Get the web driver wait.
	 * @return WebDriverWait
	 */
	public static WebDriverWait getWait() {
		return wait;
	}
	
	/**
	 * Get the  web driver.
	 * @return WebDriver
	 */
	protected WebDriver getDriver() {
		return driver;
	}
	
	/**
	 * Close the web driver.
	 */
	public void dispose() {
		if (driver != null) {
			driver.quit();
		}
	}

	/**
	 * Wait element to be visible.
	 * @param element : WebElement
	 */
	public static void waitElementVisibility(WebElement element) {
		getWait().until(ExpectedConditions.visibilityOf(element));
	}
	

	/**
	 * Click in profile button and next button.
	 * @param element : WebElement
	 */
	public static void profileClick(WebElement user, WebElement option) {
		waitElementVisibility(user);
		getWait().until(ExpectedConditions.elementToBeClickable(user));
		user.click();
		getWait().until(ExpectedConditions.elementToBeClickable(option));
	 	option.click();
	}
	
	/**
	 * Login in the page.
	 * @param element : WebElement, user name and password
	 */
	public void logInClick(String uname, String pwd, WebElement email, WebElement password, WebElement buttonLogIn) {
		getWait().until(ExpectedConditions.visibilityOf(email));
		email.sendKeys(uname);
		password.sendKeys(pwd);	
		getWait().until(ExpectedConditions.visibilityOf(buttonLogIn));
		getWait().until(ExpectedConditions.elementToBeClickable(buttonLogIn));
		buttonLogIn.click();
	}	
		
	public void waitSec(int time) {
	 try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
