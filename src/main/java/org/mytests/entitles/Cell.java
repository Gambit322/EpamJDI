package org.mytests.entitles;

/**
 * Created by Олег on 01.12.2016.
 */
public class Cell {
    public int columnIndex;
    public int rowIndex;
    public String text;

    public Cell(int columnIndex, int rowIndex, String text){
        this.columnIndex = columnIndex;
        this.rowIndex = rowIndex;
        this.text=text;
    }
}
