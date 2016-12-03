package org.mytests.tests;


import org.mytests.DataProviders;
import org.mytests.InitTests;
import org.mytests.entitles.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;
import static org.mytests.JdiSite.*;
import static org.mytests.enums.Preconditions.LOGOUT;


/**
 * Created by Alexander_Petrovskiy on 5/23/2016.
 */
public class LoginTest extends InitTests {

    @BeforeMethod
    public void before()  {
        isInState(LOGOUT);
        homePage.isOpened();
    }

    @Test(dataProviderClass = DataProviders.class,dataProvider="loginTest")
    public void login(User user,boolean stateData) {
        homePage.refresh();
        loginForm.submit(user);
        loginForm.checkLogin(stateData);
    }
}
