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
  
	@BeforeTest(alwaysRun=true)
	@Parameters({"browser", "url"})
	public void BeforeTest(String browser, String url) {
		driver= new Driver(browser);
		espnHome= new EspnHomePage(driver.getDriver(), url);
	 }
		
	
	 public EspnHomePage getEspnHome() {
		 return espnHome;
	 }
	 
	 
	 @AfterClass
	public void afterClass() { 
		 System.out.println("Ejecutar Cerrar Sesion ");
		 
	 }
	 
	 @AfterTest
	 public void afterTest() {
		 System.out.println("Final");
		 EspnHomePage.logOut();
		 espnHome.dispose();
	 }
	 
	 
	 
}
