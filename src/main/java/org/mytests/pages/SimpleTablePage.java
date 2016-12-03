package org.mytests.pages;

import com.epam.jdi.uitests.core.interfaces.common.ICheckBox;
import com.epam.jdi.uitests.core.interfaces.common.ITextField;
import com.epam.jdi.uitests.web.selenium.elements.complex.table.interfaces.ITable;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JTable;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Олег on 21.11.2016.
 */
public class SimpleTablePage extends WebPage {
    @JTable(
            root = @FindBy(xpath = "/html/body/div/div/main/div[2]/div/table"),
            row = @FindBy(xpath = ".//tr[%s]//td"),
            column = @FindBy(xpath = ".//tr//td[%s]"),
            header= {"Drivers", "Selenium Custom", "JavaScript, Appium, WinAPI, Sikuli"}
    )
    public ITable simpleTable;

    @FindBy(css = ".info-panel-body-log")
    public ITextField logBox;


}
