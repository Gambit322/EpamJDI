package org.mytests.pageobject;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.common.ITextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import org.openqa.selenium.support.FindBy;

import static org.mytests.JdiSite.datesPage;

/**
 * Created by Олег on 03.12.2016.
 */
public class TimePicker extends Section {
    @FindBy(xpath = "/html/body/div/div/main/div[2]/div/form/div[3]/div[2]/div[1]/div/input")
    public ITextField timeField;
    @FindBy(css =".fa-clock-o")
    public IButton clockButton;
    @FindBy(css = ".bootstrap-timepicker-hour")
    public ITextField hourField;
    @FindBy(css = ".bootstrap-timepicker-minute")
    public ITextField minuteField;
    @FindBy(css = ".bootstrap-timepicker-meridian")
    public ITextField dayTimeField;
    @FindBy(xpath = "/html/body/div[2]/table/tbody/tr[1]/td[1]/a")
    public IButton incrementHour;
    @FindBy(xpath = "/html/body/div[2]/table/tbody/tr[3]/td[1]/a")
    public IButton decrementHour;
    @FindBy(xpath = "/html/body/div[2]/table/tbody/tr[1]/td[3]/a")
    public IButton incrementMinute;
    @FindBy(xpath = "/html/body/div[2]/table/tbody/tr[3]/td[3]/a")
    public IButton decrementMinute;
    @FindBy(xpath = "/html/body/div[2]/table/tbody/tr[1]/td[5]/a")
    public IButton incrementDayTime;
    @FindBy(xpath = "/html/body/div[2]/table/tbody/tr[3]/td[5]/a")
    public IButton decrementDayTime;

    public void setHourWithButtons(int hour){
        datesPage.timePicker.clockButton.click();
        if ((Integer.parseInt(datesPage.timePicker.hourField.getText())!= hour))
        {
            if (Integer.parseInt(datesPage.timePicker.hourField.getText()) < hour) {
                while (Integer.parseInt(datesPage.timePicker.hourField.getText()) != hour) {
                    datesPage.timePicker.incrementHour.click();
                }
            }
            else{
                while (Integer.parseInt(datesPage.timePicker.hourField.getText()) != hour) {
                    datesPage.timePicker.decrementHour.click();
                }
            }
        }
    }
    public void setMinuteWithButtons(int minute){
        datesPage.timePicker.clockButton.click();
        if ((Integer.parseInt(datesPage.timePicker.minuteField.getText())!= minute))
        {
            if (Integer.parseInt(datesPage.timePicker.minuteField.getText()) < minute) {
                while (Integer.parseInt(datesPage.timePicker.minuteField.getText()) != minute) {
                    datesPage.timePicker.incrementMinute.click();
                }
            }
            else{
                while (Integer.parseInt(datesPage.timePicker.minuteField.getText()) != minute) {
                    datesPage.timePicker.decrementMinute.click();
                }
            }
        }
    }
    public void setDayTimeWithButtons(String dayTime){
        datesPage.timePicker.clockButton.click();
       if ( !(datesPage.timePicker.dayTimeField.getText().equals(dayTime)))
           datesPage.timePicker.incrementDayTime.click();
    }

}
