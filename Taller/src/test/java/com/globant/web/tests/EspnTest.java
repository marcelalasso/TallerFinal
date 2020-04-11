package com.globant.web.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.globant.web.driver.Driver;
import com.globant.web.pages.EspnHomePage;

/**
 * Parent of the other classes of test.
 * @author edith.lasso
 */

public class EspnTest {
	Driver driver;
	
	protected EspnHomePage espnHome;
	public static Logger log = Logger.getLogger(EspnTest.class);
  
	@BeforeTest
	@Parameters({"browser", "url"})
	public void beforeTest(String browser, String url) {
		driver= new Driver(browser);
		espnHome= new EspnHomePage(driver.getDriver(), url);
	 }
	
	public EspnHomePage getEspnHome() {
		 return espnHome;
	 }
	 
	 
	 @AfterClass
	public void afterClass() { 
		
	 }
	 
	 @AfterTest
	 public void afterTest() {
		System.out.println("End Tests - Account Espn");
		espnHome.dispose();
	 }
 
}
