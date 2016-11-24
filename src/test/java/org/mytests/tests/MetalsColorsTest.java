package org.mytests.tests;
import org.mytests.DataProvider;
import org.mytests.InitTests;
import org.mytests.other.Plate;
import com.epam.web.matcher.testng.*;
import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;
import static org.mytests.JdiSite.*;
import static org.mytests.enums.Preconditions.LOGIN;
import org.testng.annotations.*;


/**
 * Created by Олег on 20.11.2016.
 */
public class MetalsColorsTest extends InitTests {
    @BeforeClass
    public void setup(){
        isInState(LOGIN);
        metalsColorsPage.isOpened();
    }

    @Test(dataProviderClass = DataProvider.class,dataProvider="MetalColorTest")
    public void metalsColorsTest(Plate plate)  {
        metalsColorsPage.refresh();
        metalsColorsPage.metalsColorlsForm.submit(plate);
        Assert.assertEquals(metalsColorsPage.sumResult.getText(),"Summary: "+String.valueOf(Integer.parseInt(plate.odds) + Integer.parseInt(plate.even)));
        for(String element : plate.elements)
           Assert.contains(metalsColorsPage.elementResult.getText(), element);
        Assert.assertEquals(metalsColorsPage.colorResult.getText(),"Color: "+ plate.color);
        Assert.assertEquals(metalsColorsPage.metalResult.getText(),"Metal: "+ plate.metals);
        for (String vegetable : plate.vegetables){
            Assert.contains(metalsColorsPage.vegetablesResult.getText(), vegetable);
        }
    }

}
