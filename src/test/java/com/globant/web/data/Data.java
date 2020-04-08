package com.globant.web.data;

import org.testng.annotations.DataProvider;

public class Data {

    @DataProvider(name = "count")
    public static Object[][] inputData() {
        return new Object[][] {{"email11@prueba.com", "prueba1234"}};
    }

    @DataProvider(name = "newcount")
    public Object[][] inputDataC() {
        return new Object[][] {{"Ana", "Ruiz", "mail25@prueba.com", "prueba1234"}};
    }
}

