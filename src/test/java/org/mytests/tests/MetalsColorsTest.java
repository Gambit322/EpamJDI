package org.mytests.tests;
import org.junit.Assert;
import org.mytests.DataProvider;
import org.mytests.other.Plate;
import org.testng.annotations.Test;
import static org.mytests.JdiSite.*;


/**
 * Created by Олег on 20.11.2016.
 */
public class MetalsColorsTest {

    @Test(dataProviderClass = DataProvider.class,dataProvider="MetalColorTest")
    public void metalsColorsTest(Plate plate) throws InterruptedException {
        metalsColorsPage.isOpened();
        metalsColorsPage.refresh();
        metalsColorsPage.metalsColorlsForm.submit(plate);
        Assert.assertEquals(metalsColorsPage.sumResult.getText(),"Summary: "+String.valueOf(Integer.parseInt(plate.odds) + Integer.parseInt(plate.even)));
        for(String element : plate.elements)
            com.epam.web.matcher.testng.Assert.contains(metalsColorsPage.elementResult.getText(), element);
        Assert.assertEquals(metalsColorsPage.colorResult.getText(),"Color: "+ plate.color);
        Assert.assertEquals(metalsColorsPage.metalResult.getText(),"Metal: "+ plate.metals);
        for (String vegetable : plate.vegetables){
            com.epam.web.matcher.testng.Assert.contains(metalsColorsPage.vegetablesResult.getText(), vegetable);
        }
    }

}
