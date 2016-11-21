package org.mytests.pageobject;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Олег on 21.11.2016.
 */
public class SummarySection extends Section{
    @FindBy(css = "#odds-selector p")
    public RadioButtons odds;
    @FindBy(css = "#even-selector p")
    public RadioButtons even;
    @FindBy (id = "calculate-button")
    public Button calculate;
}
