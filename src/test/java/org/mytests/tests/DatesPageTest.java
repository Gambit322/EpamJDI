package org.mytests.tests;


import com.epam.web.matcher.testng.Assert;
import org.mytests.*;
import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;
import static org.mytests.JdiSite.*;
import org.testng.annotations.BeforeClass;
import static org.mytests.enums.Preconditions.LOGIN;
import org.testng.annotations.*;

/**
 * Created by Олег on 02.12.2016.
 */
public class DatesPageTest extends InitTests {
    @BeforeClass
    public void setup(){
        isInState(LOGIN);
        datesPage.isOpened();
    }
    @Test(dataProviderClass = DataProviders.class,dataProvider = "dateTest")
    public void datePickerTest(String date) throws InterruptedException {
        datesPage.datepicker.newInput(date);
        datesPage.submit.click();
        Assert.assertEquals(datesPage.periodResult.getText(),"Period: "+date);
    }
    @Test(dataProviderClass = DataProviders.class,dataProvider = "range1Test")
    public void range1Test(String from,String to)  {
        datesPage.range1From.newInput(from);
        datesPage.range1To.newInput(to);
        datesPage.submit.click();
        Assert.assertEquals(datesPage.range1Result.getText(),"Range 1: from "+from+" to "+to);
    }
}
