package org.mytests;

import org.mytests.other.Plate;

/**
 * Created by Олег on 16.11.2016.
 */
public class DataProvider {
    @org.testng.annotations.DataProvider(name = "checkBoxTest")
    public static Object[][] checkBoxTest() {
        return new Object[][]{
                {true,true,true,true},
                {false,true,false,false},
                {false,false,true,true},
                {true,false,true,false},
                {true,false,false,true}
        };
    }
    @org.testng.annotations.DataProvider(name ="loginTest")
    public static Object[][] login(){
        return  new Object[][] {
                {"dfg","srth",false} ,
                {"123","dfg",false },
                {"222","ert",false},
                {"222","drg",false},
                {"epam","1234",true}
        };
    }
    @org.testng.annotations.DataProvider(name ="MetalColorTest")
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
    @org.testng.annotations.DataProvider(name ="searchTest")
    public static Object[][] search(){
        return  new Object[][] {
                {"epam"},{"dfgkjsdg"},{"jfi"},{"test"}
        };
    }
}