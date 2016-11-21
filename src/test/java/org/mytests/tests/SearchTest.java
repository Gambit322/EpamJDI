package org.mytests.tests;

import org.mytests.DataProvider;
import org.mytests.InitTests;
import org.testng.annotations.Test;

import static org.mytests.JdiSite.homePage;
import static org.mytests.JdiSite.searchForm;
import static org.mytests.JdiSite.supportPage;

/**
 * Created by Олег on 21.11.2016.
 */
public class SearchTest extends InitTests {
    @Test(dataProviderClass = DataProvider.class,dataProvider="searchTest")
  public void searchTest(String input){
        searchForm.findAction(input);
        supportPage.checkOpened();
    }
}
