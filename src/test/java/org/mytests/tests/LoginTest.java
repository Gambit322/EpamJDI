package org.mytests.tests;

import org.mytests.DataProvider;
import org.mytests.InitTests;
import org.mytests.other.User;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.lang.reflect.Method;

import static org.mytests.JdiSite.*;


/**
 * Created by Alexander_Petrovskiy on 5/23/2016.
 */
public class LoginTest extends InitTests {

    @BeforeMethod
    public void before(Method method) throws IOException {
        homePage.isOpened();
    }
    @org.testng.annotations.Test(dataProviderClass = DataProvider.class,dataProvider="loginTest")
    public void login(String name, String password,boolean stateData) {
        homePage.refresh();
        loginForm.login(new User(name,password));
        loginForm.checkLogin(stateData);
    }

}
