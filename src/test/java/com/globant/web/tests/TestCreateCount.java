package com.globant.web.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.globant.web.data.Data;
import com.globant.web.pages.EspnHomePage;

public class TestCreateCount extends EspnTest {
	 
	/**
	 * Test Create Count ESPN
	 */
	  @Test(description = "Data Provider New Count", dataProviderClass = Data.class, dataProvider = "newcount")
	  public void createCount(String fname, String lname, String mail, String pwd) {  	  
		  log.info("Test CreateCount");
		  EspnHomePage home=getEspnHome();
		  home.createCount(fname, lname, mail, pwd);
		  Assert.assertEquals(home.verName().contains(fname),true);
	  }
	 
}
