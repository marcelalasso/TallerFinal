package com.globant.web.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.globant.web.data.Data;
import com.globant.web.pages.EspnHomePage;
import com.globant.web.pages.LogInPage;

public class TestLogin extends EspnTest {
	 
	/**
	 * 	Test Login ESPN
	 */
 
	  @Test(description = "Data Provider Login", dataProviderClass = Data.class, dataProvider = "count")
	  public void testLogin(String uname, String pwd) {  	  
		  EspnHomePage home=getEspnHome();
		  home.logIn(uname, pwd);
		  //Assert.assertNotEquals(home.verYouTube(),"0", "Correcto");
	  } 

}
