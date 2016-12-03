package org.mytests.tests;


import com.epam.web.matcher.testng.Assert;
import org.mytests.*;
import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;
import static org.mytests.JdiSite.*;
import org.testng.annotations.BeforeMethod;
import static org.mytests.enums.Preconditions.LOGIN;
import org.testng.annotations.Test;

/**
 * Created by Олег on 02.12.2016.
 */
public class DatesPageTest extends InitTests {
    @BeforeMethod
    public void setup(){
        isInState(LOGIN);
        datesPage.isOpened();
    }
    @Test(dataProviderClass = DataProviders.class,dataProvider = "dateTest")
    public void datePickerTest(String date)  {
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
    @Test(dataProviderClass = DataProviders.class,dataProvider = "timePickerButtonTest")
    public void timePickerButtonTest(int hour,int minute,String dayTime)  {
        datesPage.timePicker.setHourWithButtons(hour);
        datesPage.timePicker.setMinuteWithButtons(minute);
        datesPage.timePicker.setDayTimeWithButtons(dayTime);
        datesPage.submit.click();
        if (minute == 0) // если вводим 0 минут, должно отображаться 00 минут
            Assert.assertEquals(datesPage.timePicker.timeField.getText(),hour+":"+minute+"0 "+dayTime);
        else
            Assert.assertEquals(datesPage.timePicker.timeField.getText(),hour+":"+minute+" "+dayTime);
    }
    @Test(dataProviderClass = DataProviders.class,dataProvider = "timePickerInputTest")
    public void timePickerInputTest(String hour,String minute, String dayTime,String expectedTime) {
        datesPage.timePicker.clockButton.click();
        datesPage.timePicker.hourField.newInput(hour);
        datesPage.timePicker.minuteField.newInput(minute);
        datesPage.timePicker.dayTimeField.newInput(dayTime);
        Assert.assertEquals(datesPage.timePicker.timeField.getText(),expectedTime);
    }
}
