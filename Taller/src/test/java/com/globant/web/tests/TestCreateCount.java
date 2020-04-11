package com.globant.web.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.globant.web.data.Data;
import com.globant.web.pages.EspnHomePage;

public class TestCreateCount extends EspnTest {
	 
	/**
	 * Test Create Count ESPN
	 */
	  @Test(description = "Data Provider New Count", dataProviderClass = Data.class, dataProvider = "newaccount")
	  public void createCount(String fname, String lname, String mail, String pwd) {  	  
		  log.info("Test: Create Account");
		  EspnHomePage home=getEspnHome();
		  home.createCount(fname, lname, mail, pwd);
		  Assert.assertEquals(home.verName().contains(fname),true, "Error - The account could not be created");
		  Assert.assertTrue(EspnHomePage.verLogout(), "Error - Element is not displayed");
	  }
	  
	  @Override
	  @AfterTest
		 public void afterTest() {
		  log.info("Close - End Test Create Account");
			espnHome.logOut();
			espnHome.dispose();
		 }
	 
}
