package org.mytests.tests;


import com.epam.web.matcher.testng.Assert;
import org.mytests.DataProviders;
import org.mytests.InitTests;
import org.mytests.entitles.Cell;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.mytests.enums.*;


import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;
import static org.mytests.JdiSite.complexTablePage;
import static org.mytests.enums.Preconditions.LOGIN;

/**
 * Created by Олег on 28.11.2016.
 */
public class ComplexTablePageTest extends InitTests {
    @BeforeMethod
    public void setup() {
        isInState(LOGIN);
        complexTablePage.isOpened();
    }
    @Test(dataProviderClass = DataProviders.class,dataProvider="complexTablePageTest")
    public void complexTablePageTest(ColumnsHeaders[] names)  {
        complexTablePage.tableColumn.uncheckAll();
        for (ColumnsHeaders name : names)
        complexTablePage.tableColumn.selectByEnum(name);
        complexTablePage.apply.click();
        Assert.assertEquals(complexTablePage.complexTable.columns().count(),names.length+1);
    }
    @Test
    public void restablishButtonTest(){
        complexTablePage.restablish.click();
        Assert.assertEquals(complexTablePage.complexTable.columns().count(),4);
    }
    @Test(dataProviderClass = DataProviders.class,dataProvider = "cellTest")
    public void cellTest(Cell[] cel)  {
        complexTablePage.refresh();
        complexTablePage.restablish.click();
        for (Cell cell :cel) {
            complexTablePage.complexTable.cell(cell.columnIndex, cell.rowIndex).get().get(By.cssSelector(".stripe tbody tr td p.checkbox label")).click(); // кликаем на чекбокс
             Assert.assertContains(complexTablePage.logBox.getFirstText(),"Select: condition changed to true");
            complexTablePage.complexTable.cell(cell.columnIndex, cell.rowIndex).get().get(By.cssSelector(".stripe tbody tr td a.seeMore")).click(); //кликаем на See More
            Assert.assertContains(complexTablePage.logBox.getFirstText(),"See More link clicked");
            Assert.assertEquals(complexTablePage.complexTable.cell(cell.columnIndex, cell.rowIndex).get().get(By.xpath("/html/body/div/div/main/div[2]/div/table/tbody/tr/td/div/table/tbody/tr[" + cell.rowIndex + "]/td[" + cell.columnIndex + "]/p[2]")).getText(),cell.text);
            //текст из ячейки соответствует тексту из дата провайдера
        }
    }
}

