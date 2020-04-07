package com.globant.web.tests;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
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
  
	@BeforeTest
	@Parameters({"browser", "url"})
	public void BeforeSuite(String browser, String url) {
		driver= new Driver(browser);
		espnHome= new EspnHomePage(driver.getDriver(), url);
	 }
		
	
	 public EspnHomePage getEspnHome() {
		 return espnHome;
	 }
	 
	 
	 @AfterClass(alwaysRun=true)
	public void afterClass() { 
		 System.out.println("Ejecutar Cerrar Sesion ");
	 }
	 
	 @AfterTest
	 public void afterTest() {
		// espnHome.dispose();
		 System.out.println("Final");
	 }
	 
	 
	 
}
