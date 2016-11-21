package org.mytests;

import com.epam.jdi.uitests.web.selenium.elements.composite.Pagination;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import org.mytests.pageobject.LoginForm;
import org.mytests.pageobject.MyPaginator;
import org.mytests.pageobject.SearchForm;
import org.mytests.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

@JSite(domain = "https://jdi-framework.github.io/tests")
public class JdiSite extends WebSite {

    @JPage(url = "/index.htm", title = "Index Page")
    public  static HomePage homePage;
    @JPage(url = "/page8.htm", title = "Different Element")
    public static DifferentElementPage differentElementPage;
    @JPage(url = "/page7.htm", title = "Table with pages")
    public  static TableWithPages tableWithPages;
    @JPage(url = "/page6.htm", title = "Simple Table")
    public  static SimpleTablePage simpleTablePage;
    @JPage(url = "/page5.htm", title = "Complex Table")
    public  static ComplexTablePage complexTablePage;
    @JPage(url = "/page4.htm", title = "Dates")
    public  static DatesPage datesPage;
    @JPage(url = "/page3.htm", title = "Support")
    public  static SupportPage supportPage;
    @JPage(url = "/page2.htm", title = "Metal and Colors")
    public  static MetalsColorsPage metalsColorsPage;
    @JPage(url = "/page1.htm", title = "Contact Form")
    public  static ContactPage contactPage;

    @FindBy(css = ".uui-profile-menu")
    public static LoginForm loginForm;
    @FindBy(css = ".search .icon-search")
    public static SearchForm searchForm;
    @FindBy(id = "uui-pagination")
    public static MyPaginator paginator;

}
