package org.mytests.tests;

import junit.framework.Assert;
import org.mytests.DataProvider;
import org.mytests.InitTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.mytests.JdiSite.*;

/**
 * Created by Олег on 16.11.2016.
 */
public class DifferentElementPageTest extends InitTests {
    @BeforeMethod
    public void setup() {
        differentElementPage.isOpened();
    }

    @Test(dataProviderClass = DataProvider.class, dataProvider = "checkBoxTest")
    public void checkBoxTest(boolean waterState, boolean earthState, boolean fireState, boolean windState) {
        differentElementPage.checkAllCheckBox(waterState, earthState, fireState, windState);
    }
    // @Test
    //public void radioButtonTest() throws InterruptedException {
    //  differentElementPage.metal.select(1);
    //differentElementPage.metal.select("Silver");
    //differentElementPage.metal.select(Metals.BRONZE);
//        differentElementPage.metal.select(4);
////  differentElementPage.metal.isSelected(Metals.SILVER);
    //String str1 = differentElementPage.metal.getSelected();
    //int x1 = differentElementPage.metal.getSelectedIndex();
//}
    @Test
    public void buttonTest(){
        differentElementPage.defaultButton.click();
        Date currentDate = new Date(); // текущие дата и время
        SimpleDateFormat d1= new SimpleDateFormat("HH:mm:ss ");
        String str = differentElementPage.logBox.getText();
        String[] st = str.split("\n");//разбиваем текст на строки
        System.out.println(str);
        Assert.assertEquals(d1.format(currentDate)+"Default Button:button clicked",st[0]); //проверяем что последняя запись в окошке с логами "текущее время Default Button:button clicked"
        differentElementPage.button.click();
        currentDate = new Date();
        str = differentElementPage.logBox.getText();
        st = str.split("\n");//разбиваем текст на строки
        Assert.assertEquals(d1.format(currentDate)+"button:button clicked",st[0]); //проверяем что последняя запись в окошке с логами "текущее время button:button clicked"
    }

}