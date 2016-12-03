package org.mytests.entitles;

/**
 * Created by Олег on 16.11.2016.
 */
public class User {
    private String login;
    private String password;

    public User(String name, String password) {
        this.login = name;
        this.password = password;
    }
    public String  getName(){
        return login;
    }

    public String getPassword() {
        return password;
    }
}
