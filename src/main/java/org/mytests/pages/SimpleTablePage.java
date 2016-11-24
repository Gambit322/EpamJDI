package org.mytests.pages;

import com.epam.jdi.uitests.web.selenium.elements.complex.table.*;
import com.epam.jdi.uitests.web.selenium.elements.complex.table.Table;
import com.epam.jdi.uitests.web.selenium.elements.complex.table.interfaces.ITable;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JTable;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Олег on 21.11.2016.
 */
public class SimpleTablePage extends WebPage {
    @JTable(
            root = @FindBy(xpath = "/html/body/div/div/main/div[2]/div/table"),
            row = @FindBy(xpath = ".//tr[%s]//td"),
            column = @FindBy(xpath = ".//tr//td[%s]")
      // header = {"JOB_NAME", "JOB_CATEGORY", "JOB_LOCATION", "APPLY"})
    )
    public ITable simpleTable;
}
