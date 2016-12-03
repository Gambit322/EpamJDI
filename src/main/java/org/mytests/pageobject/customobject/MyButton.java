package org.mytests.pageobject.customobject;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;

/**
 * Created by Олег on 03.12.2016.
 */
public class MyButton extends Button {
    public static int count;
    public static double time;

    @Override
    public void clickAction() {
        long start = System.currentTimeMillis();
        getWebElement().click();
        time += (System.currentTimeMillis()- start) / 1000.0;
        count++;
    }
}
