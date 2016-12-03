package org.mytests.pages;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.common.ILabel;
import com.epam.jdi.uitests.core.interfaces.common.ITextField;
import com.epam.jdi.uitests.web.robot.RFileInput;

import com.epam.jdi.uitests.web.selenium.elements.common.DatePicker;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import org.mytests.pageobject.ContactForm;
import org.mytests.pageobject.TimePicker;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Олег on 21.11.2016.
 */
public class DatesPage extends WebPage {
    public TimePicker timePicker;
    @FindBy(css = "#datepicker input")
    public DatePicker datepicker;
    @FindBy(css = "[data-provides=fileinput]")
    public RFileInput rImageInput;
    @FindBy(css = "[class=filename] span")
    public ILabel uploadedFileName;
    @FindBy(css = "main form")
    public ContactForm contactForm;
    @FindBy(css = ".dark-blue.m-t35")
    public IButton submit;
    @FindBy(xpath = "/html/body/div/div/main/div[2]/div/form/div[4]/div[1]/div/input[1]")
    public ITextField range1From;
    @FindBy(xpath = "/html/body/div/div/main/div[2]/div/form/div[4]/div[1]/div/input[2]")
    public ITextField range1To;
    @FindBy(css = ".results li.range-res")
    public ITextField range1Result;
    @FindBy(css = ".results li.date-res")
    public ITextField periodResult;



}
