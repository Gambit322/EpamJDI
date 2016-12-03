package org.mytests.tests;

import com.epam.jdi.uitests.web.selenium.elements.complex.table.Rows;
import com.epam.web.matcher.testng.Assert;
import org.mytests.*;
import org.mytests.DataProviders;
import org.testng.annotations.*;
import java.util.ArrayList;
import java.util.List;
import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;
import static org.mytests.JdiSite.tableWithPages;
import static org.mytests.enums.Preconditions.LOGIN;

/**
 * Created by Олег on 29.11.2016.
 */
public class TableWithPagesTest extends InitTests {
    @BeforeMethod
    public void setup() {
        isInState(LOGIN);
        tableWithPages.isOpened();
    }
    @Test(dataProviderClass = DataProviders.class , dataProvider = "SortByAlphabet")
    public void sortByAlphabet(String header,int column)  {
        tableWithPages.refresh();
        sortByIncresease(header,column);
       Assert.assertTrue ((tableWithPages.table.cell(column,1).getText().charAt(0) <
          tableWithPages.table.cell(column,tableWithPages.table.rows().count()).getText().charAt(0)) );
        sortByDecresease(header,column);
        Assert.assertTrue ((tableWithPages.table.cell(column,1).getText().charAt(0) >
                tableWithPages.table.cell(column,tableWithPages.table.rows().count()).getText().charAt(0)) );

    }
    public void sortByIncresease (String header,int column){
        if(tableWithPages.table.cell(column,1).getText().charAt(0) >
                tableWithPages.table.cell(column,tableWithPages.table.rows().count()).getText().charAt(0))
        {
            tableWithPages.table.header(header).click();
        }
    }
    public void sortByDecresease (String header,int column){
        if(tableWithPages.table.cell(column,1).getText().charAt(0) <
                tableWithPages.table.cell(column,tableWithPages.table.rows().count()).getText().charAt(0))
        {
            tableWithPages.table.header(header).click();
        }
    }

    @Test
    /* Записей в таблице 11,проверить что  отображаются 15 и 20 невозможно, добавьте записей
    Если бы записей было 21 и больше, можно было бы создать енум (5,10,15,20) передавать их в ДП
    и в тесте выбирать его, и проверять что rows().count равно значению енума и  под таблицей
     строка содержит Showing 1 to значение енума of
    */
    public void showTest()  {
        tableWithPages.refresh();
        tableWithPages.numberOfElements.select("5");
        Assert.assertTrue( tableWithPages.table.rows().count() == 5 );
        Assert.assertContains(tableWithPages.showingInfo.getText(),"Showing 1 to 5 of");
        tableWithPages.numberOfElements.select("10");
        Assert.assertTrue( tableWithPages.table.rows().count() == 10 );
        Assert.assertContains(tableWithPages.showingInfo.getText(),"Showing 1 to 10 of");
        tableWithPages.numberOfElements.select("15");
        Assert.assertTrue( tableWithPages.table.rows().count() == 11 );
        Assert.assertContains(tableWithPages.showingInfo.getText(),"Showing 1 to 11 of");
        tableWithPages.numberOfElements.select("20");
        Assert.assertTrue( tableWithPages.table.rows().count() == 11 );
        Assert.assertContains(tableWithPages.showingInfo.getText(),"Showing 1 to 11 of");
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "searchTableTest")
    public void searchTest(String text, boolean textState) {
        tableWithPages.search.newInput(text);
        Rows results = tableWithPages.table.rows();
        if (textState) {
            List<String> list = new ArrayList<String>();
            for (int i = 1; i <= tableWithPages.table.rows().count(); i++) {
                list = results.getRowValue(i);
                for (String a : list) {
                    if (a.equals("Type Now Plans"))
                        ;
                    else
                        Assert.ignoreCase().contains(a, text);
                }
            }
        } else
            Assert.assertEquals(tableWithPages.table.cell(1, 1).getText(), "No matching records found");
    }

}