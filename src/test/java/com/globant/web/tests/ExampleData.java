package com.globant.web.tests;

import com.globant.web.data.Data;


import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ExampleData {

    @DataProvider(name = "dataProvider")
    public Object[][] inputData() {
        return new Object[][] {{"data1"}, {"data2"}, {"data3"}};
    }

    public Logger log = Logger.getLogger(ExampleData.class);

    @Parameters({"string1", "string2"})
    @Test(description = "example use of parameters", groups = {"group1"})
    public void testWithParameters(String param1, String param2) {
    //    log.info(param1);
     //   log.info(param2);
    }

    @Test(description = "example data provider", dataProvider = "dataProvider", groups = {"group1", "group2"})
    public void testWithDataProvider(String data) {
       // log.info(data);
    }

    @Test(description = "example data provider class", dataProviderClass = Data.class, dataProvider = "count")
    public void testWithDaraProviderClass(String uname, String pwd) {
    	//log.info("Mi prueba");
    	//log.info(data);
    	System.out.println("you have provided username as::"+uname);
		System.out.println("you have provided password as::"+pwd);
    	
    }
    
    @Test(description = "example data provider class", dataProviderClass = Data.class, dataProvider = "newcount")
    public void testWithDaraProviderClass2(String uname, String pwd, String lastname, String name) {
    	//log.info("Mi prueba");
    	//log.info(data);
    	System.out.println("you have provided username as::"+uname);
		System.out.println("you have provided password as::"+pwd);
		System.out.println("you have provided username as::"+name);
		System.out.println("you have provided password as::"+lastname);
    	
    }
}
