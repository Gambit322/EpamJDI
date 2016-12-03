package org.mytests.pageobject;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Олег on 27.11.2016.
 */
public class ContactSummarySection extends Section {
    @FindBy(css = ".info-panel-section section.horizontal-group p")
    public RadioButtons odds;
    @FindBy(css = ".info-panel-section section.horizontal-group p")
    public RadioButtons even;
    @FindBy (css = ".info-panel-section div.text-right.m-t20 button.uui-button.dark-blue")
    public Button calculate;
}
