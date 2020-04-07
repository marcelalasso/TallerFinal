package com.globant.web.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.globant.web.data.Data;
import com.globant.web.pages.EspnHomePage;

public class TestCreateCount extends EspnTest {
	 
	/**
	 * Test Create Count ESPN
	 */
	  @Test(description = "Data Provider New Count", dataProviderClass = Data.class, dataProvider = "newcount")
	  public void createCount(String fname, String lname, String mail, String pwd) {  	  
		  System.out.print("CreateCount");
		  EspnHomePage home=getEspnHome();
		  home.createCount(fname, lname, mail, pwd);
		  //Assert.assertNotEquals(home.verYouTube(),"0", "Correcto");
	  }
	 
}
