package org.mytests.tests;

import com.epam.web.matcher.testng.*;
import org.mytests.InitTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;
import static org.mytests.JdiSite.*;
import static org.mytests.enums.Preconditions.LOGIN;

/**
 * Created by Олег on 21.11.2016.
 */
public class NavigationTest  extends InitTests{
   @BeforeMethod
   public void setup() {
      isInState(LOGIN);
      differentElementPage.isOpened();
   }
   @Test
    public void paginatorNextTest()  {
       paginator.next();
       metalsColorsPage.checkOpened();

   }
   @Test
   public void paginatorPrevTest(){
      paginator.previous();
      tableWithPages.checkOpened();
   }
   @Test
   public void paginatorFirstTest(){
      paginator.first();
      contactPage.checkOpened();
      paginator.previous();
      Assert.contains(contactPage.getDriver().getCurrentUrl(),"page1.htm");
   }
   @Test
   public void paginatorLastTest(){
      paginator.last();
      metalsColorsPage.checkOpened();
      paginator.next();
      Assert.contains(contactPage.getDriver().getCurrentUrl(),"page2.htm");
   }

}
