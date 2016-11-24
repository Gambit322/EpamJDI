package org.mytests.pageobject;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.composite.Pagination;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Олег on 21.11.2016.
 */
public class MyPaginator extends Pagination {
    @FindBy(css = ".uui-pagination li.prev")
     public IButton prev;
    @FindBy(css = ".uui-pagination li.next a")
    public IButton next;
    @FindBy(css = ".uui-pagination li.first a")
    public IButton first;
    @FindBy(css = ".uui-pagination li.last a")
    public IButton last;

}
