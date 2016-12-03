package org.mytests.pages;

import com.epam.jdi.uitests.core.interfaces.common.ITextField;
import com.epam.jdi.uitests.core.interfaces.complex.IDropDown;
import com.epam.jdi.uitests.web.selenium.elements.complex.table.interfaces.ITable;
import com.epam.jdi.uitests.web.selenium.elements.composite.Pagination;
import com.epam.jdi.uitests.web.selenium.elements.composite.Search;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JTable;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Олег on 21.11.2016.
 */
public class TableWithPages extends WebPage {
    @FindBy(xpath = "/html/body/div/div/main/div[2]/div/div[2]/div[2]/label/input")
    public Search search;
    @JDropdown(
            root = @FindBy(css = ".dataTables_length"),
            value = @FindBy(css = ".dataTables_length label select.uui-form-element"),
            elementByName = @FindBy(tagName = "option")
    )
    public IDropDown numberOfElements;
    @FindBy(css = ".dataTables_info")
    public ITextField showingInfo;
    public Pagination tablePagination = new Pagination(By.id("DataTables_Table_0_wrapper"),
            By.linkText("Next"),
            By.linkText("Previous"));
    @JTable(
            root = @FindBy(xpath = "/html/body/div/div/main/div[2]/div/div[2]/div[3]/table"),
            row = @FindBy(xpath = ".//tr[%s]"),
            column = @FindBy(xpath = ".//tr//td[%s]") ,
            ///html/body/div/div/main/div[2]/div/div[2]/div[3]/table/tbody/tr[1]/td[3]
            header = {"Type","Now","Plans"}
    )
    public ITable table;
}
