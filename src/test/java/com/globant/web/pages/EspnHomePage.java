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

public class 	EspnHomePage extends BasePage{

	@FindBy(css="#global-user-trigger")
	private static WebElement user;
	
//li.user.hover:nth-child(2) li:nth-child(5) 
	
	@FindBy(css="#global-header ul.account-management a[tref$='login']")
	private static WebElement logIn;
	
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
	
	@FindBy(css="#global-header a[tref=\"/members/v3_1/modifyAccount\"]")
	private WebElement espnProfile;
	
	@FindBy(css="#cancel-account")
	private WebElement deleteButton;
	
	@FindBy(css=".btn-group button:nth-child(1)")
	private WebElement confirmButton;
		
	@FindBy(css="li.user.hover:nth-child(2) li:nth-child(9)")
	private static WebElement logOut;
	
	@FindBy(css="#did-ui-view  input[type='email']")
	private WebElement emailLogin;
	
	@FindBy(css="#did-ui-view button[type='submit']")
	private WebElement buttonLogIn;	
	
	@FindBy(css="#global-viewport > .global-user")
	private static WebElement container;	
	
	
	
 	
	/**
	 * Open Page
	 */
	public EspnHomePage(WebDriver Driver, String url) {
		super(Driver);		
		driver.get(url);
		driver.manage().window().maximize();
	}
	

	
	/**
	 * Create New Count
	 */ 
	public void createCount(String fname, String lname, String mail, String pwd) {
		log.info("Choose iFrame");
		profileClick(user, logIn);
		driver.switchTo().frame("disneyid-iframe");
		getWait().until(ExpectedConditions.elementToBeClickable(signUp));
		log.info("Select SingUp Button");
		signUp.click();
		log.info("Insert Data");
		getWait().until(ExpectedConditions.elementToBeClickable(firstName));
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		email.sendKeys(mail);
		password.sendKeys(pwd);
		log.info("Send Form");
		signUpForm.click();
		driver.switchTo().defaultContent();
		waitSec(5000);
		profileClick(user,logOut);
	}
	
	/**
	 * Delete existent count
	 * @return 
	 */


//	public CancelCountPage cancelCount(String uname, String pwd) {
//		logIn(uname, pwd);
//		return new CancelCountPage(getDriver());
//	}

	public void cancelCount(String uname, String pwd) {
		profileClick(user,logIn);
		log.info("Choose iFrame LogIn");
		driver.switchTo().frame("disneyid-iframe");
		logInClick(uname, pwd, email, password, buttonLogIn);
		driver.switchTo().defaultContent();
		log.info("Choose Cancel Count");
		waitSec(5000);
		profileClick(user,espnProfile);
		log.info("Go to Profile");
		waitSec(10000);
		driver.switchTo().frame("disneyid-iframe");
		log.info("Delete count");
		email.sendKeys("prueba123");
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView();", deleteButton);
		//js.executeScript("window.scrollBy(0,2000)");
		
		deleteButton.click();
		confirmButton.click();
	}

	/**
	 * Login to existent count
	 * @return 
	 */
	public void logIn(String uname, String pwd) {
		profileClick(user,logIn);
		log.info("Choose iFrame LogIn");
		driver.switchTo().frame("disneyid-iframe");
		logInClick(uname, pwd, email, password, buttonLogIn);
		driver.switchTo().defaultContent();
		waitSec(5000);
		profileClick(user,logOut);
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
