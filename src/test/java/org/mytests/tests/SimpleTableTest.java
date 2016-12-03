package org.mytests.tests;

import org.junit.Assert;
import org.mytests.DataProviders;
import org.mytests.InitTests;
import org.mytests.entitles.Cell;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;
import static com.epam.web.matcher.testng.Assert.contains;
import static org.mytests.JdiSite.simpleTablePage;
import static org.mytests.enums.Preconditions.LOGIN;

/**
 * Created by Олег on 24.11.2016.
 */
public class SimpleTableTest extends InitTests {
    @BeforeMethod
    public void setup() {
        isInState(LOGIN);
        simpleTablePage.isOpened();
    }
    @Test(dataProviderClass = DataProviders.class,dataProvider = "simpleTableTest")
    public void simpleTableTest(Cell cell) {
        Assert.assertEquals(simpleTablePage.simpleTable.columns().count(),3);
        Assert.assertEquals(simpleTablePage.simpleTable.rows().count(),6);
        simpleTablePage.simpleTable.cell(cell.columnIndex,cell.rowIndex).click();
        System.out.println( simpleTablePage.logBox.getText() );
        contains(simpleTablePage.logBox.getText(),":value="+cell.text+"; cell has been selected");
    }
}
