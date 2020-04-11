package com.globant.web.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.globant.web.data.Data;
import com.globant.web.pages.EspnHomePage;

public class TestCancelCount extends EspnTest {
	 
	/**
	 * Test Cancel Count ESPN
	 */	
	  @Test(description = "Data Provider Login", dataProviderClass = Data.class, dataProvider = "deleteaccount")
	  public void testCancelCount(String uname, String pwd) {  	  
		  log.info("Test:  Cancel Account");
		  EspnHomePage home=getEspnHome();
		  home.cancelCount(uname, pwd);
		  Assert.assertEquals(home.verNoName(),0, "Error - The account could not be canceled");
		  Assert.assertTrue(EspnHomePage.verLogIn(), "Error - User is login");
	  }
	 
}
