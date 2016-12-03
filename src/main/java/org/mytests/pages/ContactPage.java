package org.mytests.pages;

import com.epam.jdi.uitests.core.interfaces.common.ITextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import org.mytests.pageobject.ContactForm;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Олег on 21.11.2016.
 */
public class ContactPage  extends WebPage{
    public ContactForm contactForm = new ContactForm();
    @FindBy(css = "div.info-panel-body.info-panel-body-log")
    public ITextField logField;
    @FindBy(css = ".info-panel-body.info-panel-body-result")
    public ITextField resultField;

    @FindBy(css = ".results li.summ-res")
    public ITextField summaryField;
    @FindBy(css = ".results li.name-res")
    public ITextField nameField;
    @FindBy(css = ".results li.lname-res")
    public ITextField lastNameField;
    @FindBy(css = ".results li.descr-res")
    public ITextField descriptionField;
}
