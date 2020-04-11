package com.globant.web.pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
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
	public void waitElementVisibility(WebElement element) {
		getWait().until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitElementClickable(WebElement element) {
		getWait().until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	public void scrollPage(WebElement element) {
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("arguments[0].scrollIntoView();", element);	
	}
	/**
	 * Click in profile button and next button.
	 * @param element : WebElement
	 */
		
	public void waitSec(int time) {
	 try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Wait for element to appear.
	 *
	 * @param driver the driver
	 * @param element the element
	 */
	public void fwait(WebElement elements) {
		try {
			FluentWait<WebDriver> wait2 = new FluentWait<WebDriver>(driver);
			  wait2.withTimeout(Duration.ofSeconds(90))
			  .pollingEvery(Duration.ofSeconds(30))
			  .ignoring(NoSuchElementException.class);
			
			wait2.until(ExpectedConditions.elementToBeClickable(elements));
		} catch (Exception e) {
			log.info( "Exception occured" + e.getStackTrace());
		}

	}
}
