package org.mytests.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.CheckBox;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import org.junit.Assert;
import org.mytests.enums.Metals;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Олег on 21.11.2016.
 */
public class DifferentElementPage extends WebPage {
    @FindBy(xpath = "(//input[@type='checkbox'])[1]")
    public CheckBox water;
    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    public CheckBox earth;
    @FindBy(xpath = "(//input[@type='checkbox'])[3]")
    public CheckBox fire;
    @FindBy(xpath = "(//input[@type='checkbox'])[4]")
    public CheckBox wind;

   @FindBy(css = ".checkbox-row .label-radio")
   public RadioButtons<Metals> metal;

    @FindBy (css = "input.uui-button")
    public Button button;
    @FindBy (css = "button[name=\"Default Button\"]")
    public Button defaultButton;

    @FindBy (css = "div.info-panel-body.info-panel-body-log")
    public TextField logBox;

    public void checkAllCheckBox(boolean waterState,boolean earthState,boolean fireState,boolean windState){
        checkBoxSetState(water,waterState);
        checkBoxSetState(earth,earthState);
        checkBoxSetState(fire,fireState);
        checkBoxSetState(wind,windState);
        Assert.assertEquals(water.isChecked(), waterState);
        Assert.assertEquals(earth.isChecked(),earthState);
        Assert.assertEquals(fire.isChecked(),fireState);
        Assert.assertEquals(wind.isChecked(),windState);
    }
    public void checkBoxSetState(CheckBox checkBox,boolean state){
        if (state)
            checkBox.check();
        else
            checkBox.uncheck();
    }









}
