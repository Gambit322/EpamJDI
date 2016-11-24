package org.mytests.tests;

import org.mytests.DataProvider;
import org.mytests.InitTests;
import org.mytests.enums.Metals;
import org.testng.annotations.*;
import com.epam.web.matcher.testng.*;
import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;
import static org.mytests.JdiSite.*;
import static org.mytests.enums.Preconditions.LOGIN;

/**
 * Created by Олег on 16.11.2016.
 */
public class DifferentElementPageTest extends InitTests {
    @BeforeClass
    public void setup() {
        isInState(LOGIN);
        differentElementPage.isOpened();
    }
    @Test(dataProviderClass = DataProvider.class, dataProvider = "checkBoxTest")
    public void checkBoxTest(boolean waterState, boolean earthState, boolean fireState, boolean windState) {
        differentElementPage.checkAllCheckBox(waterState, earthState, fireState, windState);
    }
    @Test
    public void radioButtonTest()  {
          //работает только в хроме, в фф не работает блок с логами
         differentElementPage.metal.select(Metals.GOLD);
         //Assert.assertTrue(differentElementPage.metal.isSelected(Metals.GOLD));
         Assert.assertContains(differentElementPage.logBox.getText(),"value changed to Gold");
         differentElementPage.metal.select(Metals.SILVER);
         //Assert.assertTrue(differentElementPage.metal.isSelected(Metals.SILVER));
         Assert.assertContains(differentElementPage.logBox.getText(),"value changed to Silver");
         differentElementPage.metal.select(Metals.BRONZE);
         Assert.assertContains(differentElementPage.logBox.getText(),"value changed to Bronze");
         //Assert.assertTrue(differentElementPage.metal.isSelected(Metals.BRONZE));
         differentElementPage.metal.select(Metals.SELEN);
         Assert.assertContains(differentElementPage.logBox.getText(),"value changed to Selen");
         //Assert.assertTrue(differentElementPage.metal.isSelected(Metals.SELEN));
     }
    @Test
    public void buttonTest(){
        //работает только в хроме, в фф не работает блок с логами
        differentElementPage.defaultButton.click();
        Assert.contains(differentElementPage.logBox.getText(),"Default Button:button clicked");
        differentElementPage.button.click();
        Assert.contains(differentElementPage.logBox.getText(),"button:button clicked");
    }

}