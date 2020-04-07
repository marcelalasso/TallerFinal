package com.globant.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Parent of the other classes of test.
 * @author edith.lasso
 */

public class 	LogInPage extends BasePage{

	@FindBy(css="#did-ui-view button[type='submit']")
	private WebElement buttonLogIn;	
	
	@FindBy(css="input[type='email']")
	private WebElement email;
	
	@FindBy(css="input[type='password']")
	private WebElement password;
	
	/**
	 * Open Page
	 */
	public LogInPage(WebDriver Driver) {
		super(Driver);		
	}
	


	/**
	 * Login to existent count
	 */
	public void logIn() {
	
		log.info("Choose iFrame LogIn");
		driver.switchTo().frame("disneyid-iframe");
		getWait().until(ExpectedConditions.elementToBeClickable(email));
		email.sendKeys("email8@prueba.com");
		password.sendKeys("prueba1234");	
		buttonLogIn.click();
		//driver.switchTo().defaultContent();
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
