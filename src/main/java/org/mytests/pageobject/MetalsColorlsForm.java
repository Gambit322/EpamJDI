package org.mytests.pageobject;


import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.CheckList;
import com.epam.jdi.uitests.web.selenium.elements.complex.ComboBox;
import com.epam.jdi.uitests.web.selenium.elements.complex.DropList;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.web.matcher.testng.Assert;
import org.mytests.other.Plate;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Олег on 20.11.2016.
 */
public class MetalsColorlsForm extends Form<Plate> {
    SummarySection summary = new SummarySection();
    @FindBy(css = "#elements-checklist label")
    CheckList elements;
    public Dropdown colors = new Dropdown(By.cssSelector(".colors .filter-option"),
            By.cssSelector(".colors li span"));
    public ComboBox metals = new ComboBox(By.cssSelector(".metals .caret"),
            By.cssSelector(".metals li span"), By.cssSelector(".metals input"));
    public DropList vegetables = new DropList(By.cssSelector(".salad .caret"),
            By.cssSelector(".salad li label"));
    @FindBy(id = "submit-button")
    private Button submitButton;

    @Override
    public void submit(Plate plate)  {
        summary.odds.select(plate.odds);
        summary.even.select(plate.even);
        summary.calculate.click();
        elements.select(plate.elements);
        colors.click();
        colors.select(plate.color);
        metals.click();
        metals.select(plate.metals);
        vegetables.select("Salad");
        vegetables.select(plate.vegetables);
        submitButton.click();
    }
}
