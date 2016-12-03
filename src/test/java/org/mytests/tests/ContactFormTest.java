package org.mytests.tests;
import com.epam.web.matcher.testng.Assert;
import org.mytests.DataProviders;
import org.mytests.InitTests;
import org.mytests.entitles.ContactInfo;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;
import static org.mytests.JdiSite.contactPage;
import static org.mytests.enums.Preconditions.LOGIN;

/**
 * Created by Олег on 27.11.2016.
 */
public class ContactFormTest extends InitTests {
    @BeforeClass
    public void setup() {
        isInState(LOGIN);
        contactPage.isOpened();
    }
    @Test(dataProviderClass = DataProviders.class,dataProvider="ContactFormTest")
    public void contactFormTest(ContactInfo info)  {
        contactPage.contactForm.submit(info);
        resultCheck(info);
    }
    public void resultCheck(ContactInfo info){
        Assert.assertEquals(contactPage.nameField.getText(),"Name: "+info.name);
        Assert.assertEquals(contactPage.lastNameField.getText(),"Last Name: "+info.lastName);
        Assert.assertEquals(contactPage.descriptionField.getText(),"Description: "+info.description);
        Assert.assertEquals(contactPage.summaryField.getText(),"Summary: "+String.valueOf(Integer.parseInt(info.odds) + Integer.parseInt(info.even)));
    }

}
