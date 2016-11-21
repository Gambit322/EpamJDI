package org.mytests.pageobject;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.composite.Pagination;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Олег on 21.11.2016.
 */
public class MyPaginator extends Pagination {
    @FindBy(css = ".uui-pagination li.prev")
     public Button left;
    @FindBy(css = ".uui-pagination li.next a")
    public Button right;
    @FindBy(css = ".uui-pagination li.first a")
    public Button first;
    @FindBy(css = ".uui-pagination li.last a")
    public Button last;

}
