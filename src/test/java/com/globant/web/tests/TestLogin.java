package com.globant.web.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.globant.web.data.Data;
import com.globant.web.pages.EspnHomePage;

public class TestLogin extends EspnTest {
	 
	/**
	 * 	Test Login ESPN
	 */
 
	  @Test(description = "Data Provider Login", dataProviderClass = Data.class, dataProvider = "count", groups="GroupLogout")
	  public void testLogin(String uname, String pwd) {  	  
		  log.info("Test LogIn");
		  EspnHomePage home=getEspnHome();
		  home.logIn(uname, pwd);
		  Assert.assertTrue(EspnHomePage.verLogout());
	  } 

}
