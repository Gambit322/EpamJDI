package org.mytests.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import org.mytests.pageobject.MetalsColorlsForm;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Олег on 20.11.2016.
 */
public class MetalsColorsPage extends WebPage {
    @FindBy(css = ".form")
     public MetalsColorlsForm metalsColorlsForm = new MetalsColorlsForm();
    @FindBy(css = ".summ-res")
    public TextField sumResult;
    @FindBy(css = ".elem-res")
    public TextField elementResult;
    @FindBy(css = ".col-res")
    public TextField colorResult;
    @FindBy(css = ".met-res")
    public TextField metalResult;
    @FindBy(css = ".sal-res")
    public TextField vegetablesResult;
}
