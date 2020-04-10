package com.globant.web.data;

import java.util.Random;

import org.testng.annotations.DataProvider;

public class Data {
    @DataProvider(name = "count")
    public static Object[][] inputData() {
        return new Object[][] {{"prueba001o@test.com", "prueba1234"}};
    }

    @DataProvider(name = "newcount")
    public Object[][] inputDataC() {
    	int randomNum=generateRandomInt();
    	String mail= "mail" + Integer.toString(randomNum) + "@prueba.com";
    	return new Object[][] {{"Ana", "Ruiz", mail, "prueba1234"}};
    }
    
    @DataProvider(name = "deletecount")
    public static Object[][] inputDataD() {
        return new Object[][] {{"prueba001o@test.com", "prueba1234"}};
    }
    
	public int generateRandomInt(){
	    Random random = new Random();
	    int randomNum = (random.nextInt(500))+10;
	    System.out.print(randomNum);
	    return  randomNum;
	}
}

