package org.mytests;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.settings.WebSettings;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import com.epam.web.matcher.verify.Verify;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
import static org.mytests.JdiSite.homePage;



/**
 * Created by Roman_Iovlev on 7/13/2015.
 */
public class InitTests extends TestNGBase {

    @BeforeSuite(alwaysRun = true)
    public static void setUp() throws Exception {
        WebSite.init(JdiSite.class);
        Verify.getFails();
        logger.info("Run Tests");
        homePage.isOpened();
    }
    @AfterSuite
    public void tearDown() {
        WebSettings.getDriver().quit();
    }
}
