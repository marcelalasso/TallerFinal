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

public class 	EspnHomePage extends BasePage{

	@FindBy(css="#global-user-trigger")
	private static WebElement user;
		
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
	
	@FindBy(id="disneyid-iframe")
	private static WebElement iframes;
	
 	
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
		log.info("Choose iFrame");
		profileClick(logIn);
		driver.switchTo().frame("disneyid-iframe");
		waitElementClickable(signUp);
		log.info("Select SingUp Button");
		signUp.click();
		log.info("Insert Data");
		waitElementClickable(firstName);
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		email.sendKeys(mail);
		password.sendKeys(pwd);
		log.info("Send Form");
		signUpForm.click();
		driver.switchTo().defaultContent();
		getWait().until(ExpectedConditions.invisibilityOf(iframes));
		profileClick(logOut);
	}
	
	/**
	 * Delete existent count 
	 */
	public void cancelCount(String uname, String pwd) {
		profileClick(logIn);
		log.info("Choose iFrame LogIn");
		driver.switchTo().frame("disneyid-iframe");
		logInClick(uname, pwd);
		driver.switchTo().defaultContent();
		log.info("Choose Cancel Count");
		getWait().until(ExpectedConditions.invisibilityOf(iframes));
		fwait(user);
		profileClick(espnProfile);
		log.info("Go to Profile");
		driver.switchTo().frame("disneyid-iframe");
		log.info("Delete count");
		fwait(email);
		email.sendKeys("prueba123");
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView();", deleteButton);		
		deleteButton.click();
		confirmButton.click();
	}

	/**
	 * Login to existent count
	 */
	public void logIn(String uname, String pwd) {
		profileClick(logIn);
		log.info("Choose iFrame LogIn");
		driver.switchTo().frame("disneyid-iframe");
		logInClick(uname, pwd);
		driver.switchTo().defaultContent();
		getWait().until(ExpectedConditions.invisibilityOf(iframes));
		fwait(user);
		profileClick(logOut);
	}
	
	public static void profileClick(WebElement option) {
		waitElementVisibility(user);
		waitElementClickable(user);
		user.click();
		waitElementClickable(option);
	 	option.click();
	}
	
	/**
	 * Login in the page.
	 * @param element : user name and password
	 */
	public void logInClick(String uname, String pwd) {
		getWait().until(ExpectedConditions.visibilityOf(email));
		email.sendKeys(uname);
		password.sendKeys(pwd);	
		getWait().until(ExpectedConditions.visibilityOf(buttonLogIn));
		waitElementClickable(buttonLogIn);
		buttonLogIn.click();
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
