package org.mytests;

import com.epam.jdi.uitests.core.interfaces.MapInterfaceToElement;
import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.web.selenium.elements.common.DatePicker;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.settings.WebSettings;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import com.epam.web.matcher.verify.Verify;
import org.apache.xpath.SourceTree;
import org.mytests.pageobject.customobject.MyButton;
import org.mytests.pageobject.customobject.MyDropList;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
import static org.mytests.JdiSite.homePage;



/**
 * Created by Roman_Iovlev on 7/13/2015.
 */
public class InitTests extends TestNGBase {
    @BeforeSuite(alwaysRun = true)
    @Parameters({ "browser" })
    public static void setUp(@Optional String browser)  {
        MapInterfaceToElement.update(
                new Object[][]{
                        {IButton.class, MyButton.class},

                });
        WebSettings.useDriver(System.getProperty("browser","chrome"));
        WebSite.init(JdiSite.class);
        Verify.getFails();
        logger.info("Run Tests");
        homePage.isOpened();
    }
    @AfterSuite
    public void tearDown() {
        System.out.println("Stats for custom elements");
        System.out.println("Button");
        System.out.println("Clicks: "+MyButton.count );
        System.out.printf( "%s%.3f%s","Time: ",MyButton.time ," sec\n");
        System.out.printf( "%s%.3f%s","Average time: ",MyButton.time/MyButton.count," sec\n");
        System.out.println("DropList");
        System.out.println("Actions: "+ MyDropList.count );
        System.out.printf( "%s%.3f%s","Time: ",MyDropList.time," sec\n" );
        System.out.printf( "%s%.3f%s","Average time: ",MyDropList.time/MyDropList.count," sec\n");
        WebSettings.getDriver().quit();
    }
}
