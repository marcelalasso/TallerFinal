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

public class 	CreateCountPage extends BasePage{

	@FindBy(id="global-user-trigger")
	private WebElement user;
	
	@FindBy(css="li.user.hover:nth-child(2) li:nth-child(5)")
	private WebElement logIn;

	@FindBy(css="a.btn")
	private WebElement signUp;
	
	@FindBy(css="input[name^='firstName']")
	private WebElement firstName;
	
	@FindBy(css="input[name='lastName']")
	private WebElement lastName;
	
	@FindBy(css="input[type='email']")
	private WebElement email;
	
	@FindBy(css="input[type='password']")
	private WebElement password;
	
	@FindBy(css="#did-ui-view  button[type='submit']")
	private WebElement signUpForm;
	
	
 	
	/**
	 * Open Page
	 */
	public CreateCountPage(WebDriver Driver) {
		super(Driver);		
	}
	

	/**
	 * Create New Count
	 */ 
	public void createCount() {
		log.info("Choose iFrame");
		driver.switchTo().frame("disneyid-iframe");
		getWait().until(ExpectedConditions.elementToBeClickable(signUp));
		log.info("Select SingUp Button");
		signUp.click();
		log.info("Insert Data");
		getWait().until(ExpectedConditions.elementToBeClickable(firstName));
		firstName.sendKeys("Ana");
		lastName.sendKeys("Ruiz");
		email.sendKeys("mail5@prueba.com");
		password.sendKeys("prueba1234");
		log.info("Send Form");
		signUpForm.click();
		driver.switchTo().defaultContent();
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
