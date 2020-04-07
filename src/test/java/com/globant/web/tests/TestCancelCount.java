package com.globant.web.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.globant.web.data.Data;
import com.globant.web.pages.CancelCountPage;
import com.globant.web.pages.EspnHomePage;

public class TestCancelCount extends EspnTest {
	 
	/**
	 * Test Cancel Count ESPN
	 */	
	  @Test(description = "Data Provider Login", dataProviderClass = Data.class, dataProvider = "count")
	  public void testCancelCount(String uname, String pwd) {  	  
		  System.out.print("CancelCount");
		  EspnHomePage home=getEspnHome();
		  home.cancelCount(uname, pwd);
		  //CancelCountPage cancelCount = home.cancelCount(uname, pwd);
		  //cancelCount.cancelCount();
		  //Assert.assertNotEquals(home.verYouTube(),"0", "Correcto");
	  }
	 
}
