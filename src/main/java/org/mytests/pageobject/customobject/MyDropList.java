package org.mytests.pageobject.customobject;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.DropList;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import org.mytests.enums.ColumnsHeaders;
import org.openqa.selenium.By;

/**
 * Created by Олег on 03.12.2016.
 */
public  class MyDropList<ColumnHeaders extends Enum> extends DropList<ColumnsHeaders> {
    public static int count;
    public static double time;

    public MyDropList(By xpath, By xpath1, By xpath2) {
        super(xpath, xpath1,xpath2);
    }

    public void selectByEnum(ColumnsHeaders col){}
    public void selectByName(String name){}
    public void uncheckAll(){}
}
