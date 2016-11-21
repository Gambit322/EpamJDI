package org.mytests.pageobject;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.common.ITextField;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Search;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Олег on 21.11.2016.
 */
public class SearchForm extends Search {
    @FindBy(css = ".search-field input")
    private TextField searchField;

    @FindBy(css = ".search .icon-search")
    private Button searchButton;

    @Override
    public void  findAction(String input){
        searchButton.click();
        searchField.newInput(input);
        searchButton.click();
    }
}
