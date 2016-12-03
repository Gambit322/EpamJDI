package org.mytests.tests;

import org.mytests.DataProviders;
import org.mytests.InitTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;
import static org.mytests.JdiSite.*;
import static org.mytests.enums.Preconditions.LOGIN;

/**
 * Created by Олег on 21.11.2016.
 */
public class SearchTest extends InitTests {
    @BeforeMethod
    public void setup(){
        isInState(LOGIN);
    }

    @Test(dataProviderClass = DataProviders.class,dataProvider="searchTest")
  public void searchTest(String input){
        searchForm.findAction(input);
        supportPage.checkOpened();
    }
}
