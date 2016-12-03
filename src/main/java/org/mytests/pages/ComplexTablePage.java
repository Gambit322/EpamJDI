package org.mytests.pages;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.common.ITextField;
import com.epam.jdi.uitests.core.interfaces.complex.ITextList;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.DropList;
import com.epam.jdi.uitests.web.selenium.elements.complex.table.interfaces.ITable;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JTable;
import org.mytests.JdiSite;
import org.mytests.enums.ColumnsHeaders;
import org.mytests.pageobject.customobject.MyDropList;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Олег on 21.11.2016.
 */
public class ComplexTablePage extends WebPage {
    @JTable(
            root = @FindBy(css = ".tbl-scroll.table-delete tbody tr td div.tbl-height"),
            row = @FindBy(xpath = ".//tr[%s]//td"),
            column = @FindBy(xpath = ".//tr//td[%s]"),
           footer = @FindBy(css = ".tbl-scroll.table-delete tfoot")
    )
    public ITable complexTable;
    @FindBy(css = ".dropdown-toggle[type=button]")
    public IButton dropDownButton;
    @FindBy(xpath = "/html/body/div/div/main/div[2]/div/div[2]/button[2]")
    public IButton apply;
    @FindBy(css = ".uui-button.dark-blue")
    public IButton restablish;
    @FindBy (css = ".info-panel-body-log")
    public ITextList logBox;
    public MyDropList<ColumnsHeaders> tableColumn = new MyDropList<ColumnsHeaders>(By.cssSelector( ".dropdown-toggle[type=button]"),
            By.xpath("*//ul[contains(@class,'dropdown-menu inner selectpicker')]"),
            By.xpath("*//ul[contains(@class,'dropdown-menu inner selectpicker')]/li")) {

        @Override
        public void selectByEnum(ColumnsHeaders col) {
            long start = System.currentTimeMillis();
            JdiSite.complexTablePage.tableColumn.select(col);
            JdiSite.complexTablePage.dropDownButton.click();
            time += (System.currentTimeMillis()- start) / 1000.0;
            count++;
        }

        @Override
        public void selectByName(String name) {
            long start = System.currentTimeMillis();
            JdiSite.complexTablePage.tableColumn.select(name);
            JdiSite.complexTablePage.dropDownButton.click();
            time += (System.currentTimeMillis()- start) / 1000.0;
            count++;
        }

        @Override
        public void uncheckAll() {
            long start = System.currentTimeMillis();
            String columns = JdiSite.complexTablePage.dropDownButton.getText();
            if (!columns.equals("Nothing selected\n ")) {
                String col = columns.substring(0,columns.length()-2);  //отбрасываем " \n"
                String[] column = col.split(", ");
                for (String string : column) {
                    JdiSite.complexTablePage.tableColumn.selectByName(string);
                }
            }
            time += (System.currentTimeMillis()- start) / 1000.0;
            count++;
        }
    };
}
