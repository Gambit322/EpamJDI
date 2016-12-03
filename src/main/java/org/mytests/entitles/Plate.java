package org.mytests.entitles;

/**
 * Created by Олег on 21.11.2016.
 */
public class Plate {
    public String odds;
    public String even;
    public String[] elements;
    public String color;
    public String metals;
    public String[] vegetables;

    public Plate(String odds, String even, String water, String red, String gold, String tomato) {
    }

    public Plate(String odds, String even, String[] elements,
                 String color, String metals, String[] vegetables) {
        this.odds = odds;
        this.even = even;
        this.elements = elements;
        this.color = color;
        this.metals = metals;
        this.vegetables = vegetables;
    }
}
