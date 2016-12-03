package org.mytests.pageobject;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.common.ITextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import org.mytests.entitles.ContactInfo;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Олег on 27.11.2016.
 */
public class ContactForm extends Form<ContactInfo> {
    @FindBy(id = "Name")
    public ITextField name;
    @FindBy(id = "LastName")
    public ITextField lastName;
    @FindBy(id = "Description")
    public ITextField description;
    @FindBy(xpath = "/html/body/div/div/main/div[2]/div/form/div[3]/div[2]/button")
    public IButton submit;
    public ContactSummarySection summarySection = new ContactSummarySection();
    @Override
    public void submit(ContactInfo info){
        summarySection.odds.select(info.odds);
        summarySection.even.select(info.even);
        summarySection.calculate.click();
        super.submit(info);
    }



}
