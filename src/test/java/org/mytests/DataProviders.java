package org.mytests;

import org.mytests.entitles.Cell;
import org.mytests.entitles.ContactInfo;
import org.mytests.entitles.Plate;
import org.mytests.entitles.User;

import static org.mytests.enums.ColumnsHeaders.col1;
import static org.mytests.enums.ColumnsHeaders.col2;
import static org.mytests.enums.ColumnsHeaders.col3;
import org.testng.annotations.DataProvider;



/**
 * Created by Олег on 16.11.2016.
 */
public class DataProviders {
    @DataProvider(name = "checkBoxTest")
    public static Object[][] checkBoxTest() {
        return new Object[][]{
                {true,true,true,true},
                {false,true,false,false},
                {false,false,true,true},
                {true,false,true,false},
                {true,false,false,true}
        };
    }
    @DataProvider(name ="loginTest")
    public static Object[][] login(){
        return  new Object[][] {
                {new User("dfg","srth"),false} ,
                {new User("123","dfg"),false },
                {new User("222","ert"),false},
                {new User("2fdgdfg2","drg"),false},
                {new User("epam","1234"),true}
        };
    }
    @DataProvider(name ="MetalColorTest")
    public static Object[][] metalColorTest() {
        return new Object[][]{
                {new Plate("1","4",new String[]{"Wind", "Fire"},"Red", "Silver",
                        new String[]{"Cucumber"})},
                {new Plate("5","2",new String[]{"Water", "Fire","Earth"},"Green", "Selen",
                        new String[]{"Cucumber","Onion"})},
                {new Plate("3","6",new String[]{"Wind", "Earth"},"Blue", "Gold",
                        new String[]{"Salad","Onion"})},
                {new Plate("7","6",new String[]{"Fire"},"Yellow", "Bronze",
                        new String[]{"Tomato","Salad"})}
        };
    }
    @DataProvider(name ="searchTest")
    public static Object[][] search(){
        return  new Object[][] {
                {"epam"},{"dfgkjsdg"},{"jfi"},{"test"}
        };
    }
    @DataProvider(name ="ContactFormTest")
    public static Object[][] contactFormTest(){
        return  new Object[][] {
                {new ContactInfo("1","6","dfg","srth","sdf")} ,
                {new ContactInfo("5","2","fghdfgh","dfg","asdasd") },
                {new ContactInfo("3","8","dfghfdgh","ert","fdgdfg")},
                {new ContactInfo("7","6","sdfgsdfg","drg","dfgdf")},
                {new ContactInfo("5","4","epam","1234","asdasd")}
        };
    }
    @DataProvider(name ="complexTablePageTest")
    public static Object[][] complexTablePageTest(){
        return  new Object[][] {
                {col1},
                {col2,col3},
                {col1,col2,col3}
        };
    }
    @DataProvider(name ="searchTableTest")
    public static Object[][] searchTest(){
        return  new Object[][] {
                {"LINQ",true},
                {"Custom",true},
                {"225",false},
                {"epam",true},
                {"BDD/DSL",true},
                {"sdfsdf",false}
        };
    }
    @DataProvider(name ="SortByAlphabet")
    public static Object[][] sortByAlphabet(){
        return  new Object[][] {
                {"Type",1},
                {"Now",2},
                {"Plans",3}
        };
    }
    @DataProvider(name ="simpleTableTest")
    public static Object[][] simpleTableTest(){
        return  new Object[][] {
                {new Cell(1,1,"Drivers")},
                {new Cell(2,6,"Custom")},
                {new Cell(3,3,"MSTest, NUnit, Epam")},
                {new Cell(2,5,"Jenkins, Allure, Custom")},
                {new Cell(3,1,"JavaScript, Appium, WinAPI, Sikuli")}
        };
    }
    @DataProvider(name ="cellTest")
    public static Object[][] cellTest(){
        return  new Object[][] {
                {new Cell(2,2,"HTML5/CSS3") ,new Cell(4,1,"Programming Languages"),new Cell(4,2,"JQuery Mobile")},
                {new Cell(2,3,"(X)CSS Development"),new Cell(4,3,"Less CSS"),new Cell(4,4,"Git")},
                { new Cell(4,6,"Backend"),new Cell (3,5,"Bootstrap")},
                { new Cell(3,4,"TortoiseSVN")},
                { new Cell(4,3,"Less CSS"),new Cell(2,3,"(X)CSS Development"),new Cell(2,4,"CVS")}
        };
    }
    @DataProvider(name ="dateTest")
    public static Object[][] dateTest(){
        return  new Object[][] {
                {"12/04/2015"},
                {"05/16/2008"},
                {"01/22/2005"}
        };
    }
    @DataProvider(name ="range1Test")
    public static Object[][] range1Test(){
        return  new Object[][] {
                {"12","75"},
                {"drg","dfgdfg"}
        };
    }
}