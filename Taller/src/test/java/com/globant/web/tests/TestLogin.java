package com.globant.web.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.globant.web.pages.EspnHomePage;

public class TestLogin extends EspnTest {
	 
	/**
	 * 	Test Login ESPN
	 */
 
	  @Test(description = "Login using parameteres")
	  @Parameters({"uname", "pwd"})
	  public void testLogin(String uname, String pwd) {  	  
		  log.info("Test: LogIn");
		  EspnHomePage home=getEspnHome();
		  home.logIn(uname, pwd);
		  Assert.assertTrue(EspnHomePage.verLogout(), "Error - Element is not displayed");
		  Assert.assertNotEquals(home.verNoName(),0, "Error - User is not Login");
	  } 
	  
	  @Override
	  @AfterTest
		 public void afterTest() {
		  log.info("Close - End Test LogIn");
			espnHome.logOut();
			espnHome.dispose();
		 } 

}
