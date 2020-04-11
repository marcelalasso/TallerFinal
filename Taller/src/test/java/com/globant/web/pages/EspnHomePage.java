package com.globant.web.pages;


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
		
	@FindBy(css="a[tref$='login']")
	private static WebElement optlogin;
	
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
	
	@FindBy(css="#global-header a[tref='/members/v3_1/modifyAccount']")
	private WebElement espnProfile;
	
	@FindBy(css="#cancel-account")
	private WebElement deleteButton;
	
	@FindBy(css=".btn-group button:nth-child(1)")
	private WebElement confirmButton;
		
	@FindBy(css="#global-header .small")
	private static WebElement logOut;
	
	@FindBy(css="#did-ui-view  input[type='email']")
	private WebElement emailLogin;
	
	@FindBy(css="#did-ui-view button[type='submit']")
	private WebElement buttonLogIn;	
	
	@FindBy(id="google_ads_iframe_/21783347309/espn.com/frontpage/index_3")
	private static WebElement banner;	
	
	@FindBy(id="disneyid-iframe")
	private static WebElement iframes;
	
	@FindBy(css="#sideLogin-left-rail .button")
	private static WebElement findButton;

	@FindBy(css="#global-header li.display-user")
	private static WebElement nameUser;
	
	@FindBy(css="div.global-user-container")
	private static WebElement container;
	
	
	
 	
	/**
	 * Open Page
	 */
	public EspnHomePage(WebDriver driver, String url) {
		super(driver);		
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	/**
	 * Create New Count
	 */ 
	public void createCount(String fname, String lname, String mail, String pwd) {
		driver.manage().deleteAllCookies();
		log.info("Choose iFrame to Login");
		profileClick(optlogin);
		driver.switchTo().frame("disneyid-iframe");
		log.info("Select SingUp Button");
		waitElementClickable(signUp);
		log.info("Insert Data");
		waitElementVisibility(firstName);
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		email.sendKeys(mail);
		password.sendKeys(pwd);
		log.info("Send Form - Create Account");
		signUpForm.click();
		driver.switchTo().defaultContent();
		getWait().until(ExpectedConditions.invisibilityOf(iframes));
	}
	
	/**
	 * Delete existent count 
	 */
	public void cancelCount(String uname, String pwd) {
		driver.manage().deleteAllCookies();
		driver.switchTo().defaultContent();
		waitElementVisibility(user);
		profileClick(optlogin);
		log.info("Choose iFrame LogIn");
		driver.switchTo().frame("disneyid-iframe");
		logInClick(uname, pwd);
		driver.switchTo().defaultContent();
		getWait().until(ExpectedConditions.invisibilityOf(iframes));
		scrollPage(findButton);
		log.info("Choose Cancel Account");	
		waitElementVisibility(user);
		profileClick(espnProfile);
		log.info("Go to Profile");
		log.info("Delete account");
		waitElementVisibility(iframes);
		driver.switchTo().frame("disneyid-iframe");
		waitElementVisibility(email);
		waitSec(5000);
		email.sendKeys("prueba123");
		scrollPage(deleteButton);
		waitElementClickable(deleteButton);
		waitElementClickable(confirmButton);
	}

	/**
	 * Login to existent count
	 */
	public void logIn(String uname, String pwd) {
		driver.manage().deleteAllCookies();
		profileClick(optlogin);
		log.info("Choose iFrame to LogIn");
		driver.switchTo().frame("disneyid-iframe");
		logInClick(uname, pwd);
		driver.switchTo().defaultContent();
		getWait().until(ExpectedConditions.invisibilityOf(iframes));
		waitElementVisibility(user);
	}
	
	
	/**
	 * Click on Profile and next WebElement (LogIn, EsnProfile)
	 */
	public void profileClick(WebElement options) {
		scrollPage(findButton);
		waitElementVisibility(user);
		waitElementClickable(user);
		waitElementVisibility(container);
		waitElementVisibility(options);
		waitElementClickable(options);
	}
	
	/**
	 * Login in the page.
	 * @param element : user name and password
	 */
	public void logInClick(String uname, String pwd) {
		waitElementVisibility(email);
		email.sendKeys(uname);
		password.sendKeys(pwd);	
		log.info("LogIn");
		waitElementVisibility(buttonLogIn);
		waitElementClickable(buttonLogIn);
	}	

	/**
	 * LogOut Page
	 */
	public void logOut() {
		log.info("LogOut");
		waitElementClickable(user);
		profileClick(logOut);
	}	

	/**
	 * Verify LogOut option Exist 
	 */
	public static boolean verLogout() {
		log.info("Verify button LogOut Exist");
		user.click();
		return logOut.isDisplayed();
	}	
	
	/**
	 * Verify LogIn option Exist 
	 */
	public static boolean verLogIn() {
		log.info("Verify button LogIn Exist");
		user.click();
		return optlogin.isDisplayed();
	}
	
	/**
	 * Verify Only Welcome in profile
	 */
		public int verNoName() {
		log.info("Verify Name no Exist");
		waitElementVisibility(user);
		waitElementVisibility(user);
		waitElementClickable(user);
		waitElementVisibility(container);
		String name=nameUser.getText();
		return name.compareToIgnoreCase("welcome!");
	}

	/**
	 * Verify name in profile 
	*/
	public String verName() {
		log.info("Verify name");
		scrollPage(findButton);
		waitElementVisibility(user);
		waitElementVisibility(user);
		waitElementClickable(user);
		waitElementVisibility(container);
		String name=nameUser.getText();
		log.info("User Name= " + name);
		return name;
	}
}
