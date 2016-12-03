package org.mytests.pages;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.common.ITextField;
import com.epam.jdi.uitests.core.interfaces.complex.IRadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.common.CheckBox;
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
   public IRadioButtons<Metals> metal;

    @FindBy (css = "input.uui-button")
    public IButton button;
    @FindBy (css = "button[name=\"Default Button\"]")
    public IButton defaultButton;

    @FindBy (css = "div.info-panel-body.info-panel-body-log")
    public ITextField logBox;

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
