package org.mytests.tests;

import org.mytests.InitTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;
import static org.mytests.JdiSite.simpleTablePage;
import static org.mytests.enums.Preconditions.LOGIN;

/**
 * Created by Олег on 24.11.2016.
 */
public class SimpleTableTest extends InitTests {
    @BeforeClass
    public void setup() {
        isInState(LOGIN);
        simpleTablePage.isOpened();
    }
    @Test
    public void simpleTableTest() {

        //simpleTablePage.simpleTable.cell(2,1).click();
    }
}
