package com.globant.web.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Parent of the other classes of test.
 * @author edith.lasso
 */

public class CancelCountPage extends BasePage{

	@FindBy(css="#global-user-trigger")
	private WebElement user;
	
		
	@FindBy(css="#global-header a[tref=\"/members/v3_1/modifyAccount\"]")
	private WebElement espnProfile;
	
	@FindBy(css="input[type='email']")
	private WebElement email;
	
 	
	/**
	 * Open Page
	 */
	public CancelCountPage(WebDriver Driver) {
		super(Driver);		
	}
	

	/**
	 * Create New Count
	 */ 
	public void cancelCount() {
		log.info("Choose Cancel Count");
		waitSec(5000);
		profileClick(user,espnProfile);
		driver.switchTo().frame("disneyid-iframe");
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,2000)");
		
		log.info("Delete count");
		email.sendKeys("prueba123");
		//JavascriptExecutor js = (JavascriptExecutor) driver.switchTo().frame("disneyid-iframe");
		//js.executeScript("window.scrollBy(0,500)", "");
		//js.executeScript("arguments[0].scrollIntoView();", deleteButton);
		//deleteButton.click();
		//confirmButton.click();
	}

	
	
	//Verificar que aparece barra cuando se inicia video YouTube
	//public String verYouTube() {
		//log.info("Verify one element in YouTube Video");
		//return youTubeBar.getAttribute("aria-valuenow").toString();
	//}

	//Verificar que aparece barra cuando se inicia video Vimeo
	//public String verVimeo() {
	//	log.info("Verify one element in Vimeo Video");
	//	return vimeoBar.getAttribute("aria-valuenow").toString();
	//}

}
