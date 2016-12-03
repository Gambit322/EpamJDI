package org.mytests.enums;

/**
 * Created by Олег on 29.11.2016.
 */
public enum ColumnsHeaders {
    col1("Column 1"),
    col2("Column 2"),
    col3("Column 3");

    public String value;

    ColumnsHeaders(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
