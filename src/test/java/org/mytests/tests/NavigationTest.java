package org.mytests.tests;

import com.epam.web.matcher.testng.*;
import org.mytests.InitTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;
import static org.mytests.JdiSite.*;
import static org.mytests.enums.Preconditions.LOGIN;

/**
 * Created by Олег on 21.11.2016.
 */
public class NavigationTest  extends InitTests{
   @BeforeClass
   public void setup() {
      isInState(LOGIN);
      differentElementPage.isOpened();
   }
   @Test
    public void navigationTest()  {
       simpleTablePage.isOpened();
       paginator.previous();
       complexTablePage.checkOpened();
       paginator.next();
       simpleTablePage.checkOpened();
       paginator.first();
       contactPage.checkOpened();
       paginator.previous();
       //Assert.assertEquals(paginator.first.isDisplayed(),false);
       Assert.contains( contactPage.getDriver().getCurrentUrl(),"page1.htm");
       paginator.last();
       metalsColorsPage.checkOpened();
       paginator.next();
      // Assert.assertEquals(paginator.last.isHidden(),true);
       Assert.contains( metalsColorsPage.getDriver().getCurrentUrl(),"page2.htm");
   }
}
