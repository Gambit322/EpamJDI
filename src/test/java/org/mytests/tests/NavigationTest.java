package org.mytests.tests;

import org.junit.Assert;
import org.mytests.DataProvider;
import org.mytests.other.Plate;
import org.testng.annotations.Test;
import static org.mytests.JdiSite.*;

/**
 * Created by Олег on 21.11.2016.
 */
public class NavigationTest {
   @Test
    public void navifationTest() throws InterruptedException {
       simpleTablePage.isOpened();
       paginator.left.click();
       complexTablePage.checkOpened();
       paginator.right.click();
       simpleTablePage.checkOpened();
       paginator.first.click();
       contactPage.checkOpened();
   //  Assert.assertEquals(paginator.left.isHidden(),true);
       paginator.last.click();
       Thread.sleep(2000);
       metalsColorsPage.checkOpened();
//     Assert.assertEquals(paginator.right.isHidden(),true);
   }
}
